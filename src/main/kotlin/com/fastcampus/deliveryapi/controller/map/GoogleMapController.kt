package com.fastcampus.deliveryapi.controller.map

import com.fastcampus.deliveryapi.external.map.GoogleMapService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GoogleMapController(
    private val googleMapService: GoogleMapService,
) {
    @GetMapping("/apis/geocode")
    fun getAddress(@RequestParam lat: String, @RequestParam lng: String): String {
        val geoCodeResponse = googleMapService.getGeoCode(lat = lat, lng = lng)
        return geoCodeResponse.getLongName()
    }
}