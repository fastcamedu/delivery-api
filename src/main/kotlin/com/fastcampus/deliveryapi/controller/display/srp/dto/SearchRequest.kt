package com.fastcampus.deliveryapi.controller.display.srp.dto

data class SearchRequest(
    val keyword: String,
    val reviewGradeFilterValue: Int?,
)