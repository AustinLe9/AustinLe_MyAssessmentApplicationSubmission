package com.example.myassssmentapplication

data class Entity(
    val description: String?,
    val name: String?,
    val culture: String?,
    val domain: String?,
    val symbol: String?,
    val parentage: String?,
    val romanEquivalent: String?

)

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)
