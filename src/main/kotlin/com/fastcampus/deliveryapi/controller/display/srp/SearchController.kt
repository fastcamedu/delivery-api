package com.fastcampus.deliveryapi.controller.display.srp

import com.fastcampus.deliveryapi.controller.display.home.dto.StoreDTO
import com.fastcampus.deliveryapi.controller.display.srp.dto.SearchRequest
import com.fastcampus.deliveryapi.controller.display.srp.dto.SearchResponse
import com.fastcampus.deliveryapi.service.search.SearchService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "SearchController", description = "검색 처리 컨트롤러")
@RestController
class SearchController(
    private val searchService: SearchService,
) {
    @GetMapping("/apis/search")
    fun search(searchRequest: SearchRequest): ResponseEntity<SearchResponse> {
        val stores = searchService.search(
            keyword = searchRequest.keyword,
            reviewGrade = searchRequest.reviewGradeFilterValue
        )
        val storeDTOS = stores.map { StoreDTO.of(it) }
        return ResponseEntity.ok(SearchResponse(stores = storeDTOS))
    }
}