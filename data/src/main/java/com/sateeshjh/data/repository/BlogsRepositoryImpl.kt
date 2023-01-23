package com.sateeshjh.data.repository

import com.sateeshjh.data.mappers.toDomain
import com.sateeshjh.data.network.ApiService
import com.sateeshjh.data.network.utils.SafeApiRequest
import com.sateeshjh.domain.model.Blog
import com.sateeshjh.domain.repository.BlogsRepository
import retrofit2.Response
import javax.inject.Inject

class BlogsRepositoryImpl @Inject constructor(private val apiService: ApiService) : BlogsRepository,
    SafeApiRequest() {

    override suspend fun getBlogs(): List<Blog> {
        val response = safeApiRequest { apiService.getBlogs() }

        return response.data?.toDomain() ?: emptyList()
    }
}