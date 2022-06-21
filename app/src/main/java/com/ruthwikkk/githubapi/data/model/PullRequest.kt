package com.ruthwikkk.githubapi.data.model

import com.squareup.moshi.Json

data class PullRequest(
    @Json(name = "title")
    var name: String?,

    @Json(name = "created_at")
    var createdAt: String?,

    @Json(name = "updated_at")
    var updatedAt: String?,

    @Json(name = "closed_at")
    var closedAt: String?,

    @Json(name = "user")
    var user: User?
)
