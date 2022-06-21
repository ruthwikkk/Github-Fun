package com.ruthwikkk.githubapi.data.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "id")
    var id: Int,

    @Json(name = "login")
    var login: String?,

    @Json(name = "avatar_url")
    var imageUrl: String?
)
