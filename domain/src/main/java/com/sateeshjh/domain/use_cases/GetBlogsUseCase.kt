package com.sateeshjh.domain.use_cases

import com.sateeshjh.common.Resource
import com.sateeshjh.domain.model.Blog
import com.sateeshjh.domain.repository.BlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(private val blogsRepository: BlogsRepository){

    operator fun invoke(): Flow<Resource<List<Blog>>> = flow {
        emit(Resource.Loading(message = null))

        try {
            val response = blogsRepository.getBlogs()
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error(message = "An error occured"))
        }
    }
}