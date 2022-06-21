package com.ruthwikkk.githubapi.data.network

import com.ruthwikkk.githubapi.data.model.PullRequest
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface Api {

    @GET("/repos/{owner}/{repo}/pulls")
    suspend fun getPullRequests(@Path("owner") owner : String,
                                @Path("repo") repo : String,
                                @Query("state") state: String?,
                                @Query("page") page: Int): List<PullRequest>
}
