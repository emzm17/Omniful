package com.example.github.data

data class GResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)