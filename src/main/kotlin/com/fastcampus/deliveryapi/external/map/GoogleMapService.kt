package com.fastcampus.deliveryapi.external.map

import com.fastcampus.deliveryapi.external.map.dto.GeoCodeResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.nio.charset.StandardCharsets


@Service
class GoogleMapService(
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper,
) {

    @Value("\${google.map.url}")
    private lateinit var googleMapUrl: String

    @Value("\${google.map.key}")
    private lateinit var googleMapKey: String

    fun getGeoCode(lat: String, lng: String): GeoCodeResponse {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("latlng", "$lat,$lng")
        queryParams.add("key", googleMapKey)
        queryParams.add("language", "ko")

        val urlBuilder = UriComponentsBuilder.fromHttpUrl(googleMapUrl)
        urlBuilder.queryParams(queryParams)

        val headers = HttpHeaders()
        headers.contentType = MediaType("application", "json", StandardCharsets.UTF_8)

        val entity = HttpEntity<String>(headers)

        val responseEntity = restTemplate.exchange<String>(
            urlBuilder.build().toUri(), HttpMethod.GET, entity,
            String::class.java
        )

        return objectMapper.readValue(responseEntity.body, GeoCodeResponse::class.java)
    }
}