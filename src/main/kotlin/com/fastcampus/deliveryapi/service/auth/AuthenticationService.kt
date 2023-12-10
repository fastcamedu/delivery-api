package com.fastcampus.deliveryapi.service.auth


import com.fastcampus.deliveryapi.controller.auth.dto.AuthenticationRequest
import com.fastcampus.deliveryapi.controller.auth.dto.AuthenticationResponse
import com.fastcampus.deliveryapi.domain.customer.CustomerDetails
import com.fastcampus.deliveryapi.repository.token.RefreshToken
import com.fastcampus.deliveryapi.repository.token.RefreshTokenRepository
import com.fastcampus.deliveryapi.security.JwtProperties
import com.fastcampus.deliveryapi.service.customer.CustomerDetailsService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val customerDetailsService: CustomerDetailsService,
    private val tokenService: TokenService,
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
) {

    fun authentication(authenticationRequest: AuthenticationRequest): AuthenticationResponse {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.email,
                authenticationRequest.password
            )
        )
        val customerDetails = customerDetailsService.loadUserByUsername(authenticationRequest.email)
        val accessToken = createAccessToken(customerDetails)
        val refreshToken = createRefreshToken(customerDetails)

        val refreshTokenOptional = refreshTokenRepository.findByEmail(customerDetails.email)
        if (refreshTokenOptional.isEmpty) {
            refreshTokenRepository.save(RefreshToken(email = customerDetails.email, refreshToken = refreshToken))
        } else {
            val savedRefreshToken = refreshTokenOptional.get()
            savedRefreshToken.refreshToken = refreshToken
            refreshTokenRepository.save(savedRefreshToken)
        }

        return AuthenticationResponse(
            customerId = customerDetails.customerId,
            email = authenticationRequest.email,
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }

    fun refreshAccessToken(refreshToken: String): String? {
        val extractedEmail = tokenService.extractEmail(refreshToken)
        return extractedEmail?.let { email ->
            val currentUserDetails = customerDetailsService.loadUserByUsername(email)
            val refreshTokenOptional = refreshTokenRepository.findByEmail(email)
            if (!tokenService.isExpired(refreshToken) && refreshTokenOptional.get()?.email == currentUserDetails.email) {
                createAccessToken(currentUserDetails)
            } else {
                null
            }
        }
    }
    private fun createAccessToken(customerDetails: CustomerDetails) = tokenService.generate(
        email = customerDetails.email,
        expirationDate = getAccessTokenExpiration()
    )

    private fun createRefreshToken(customerDetails: CustomerDetails) = tokenService.generate(
        email = customerDetails.email,
        expirationDate = getRefreshTokenExpiration()
    )

    private fun getAccessTokenExpiration(): Date =
        Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)

    private fun getRefreshTokenExpiration(): Date =
        Date(System.currentTimeMillis() + jwtProperties.refreshTokenExpiration)
}