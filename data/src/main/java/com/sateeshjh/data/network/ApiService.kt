package com.sateeshjh.data.network

import com.sateeshjh.data.network.model.BlogsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("post")
    suspend fun getBlogs(): Response<BlogsDTO>
}