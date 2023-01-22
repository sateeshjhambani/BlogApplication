package com.sateeshjh.data.mappers

import com.sateeshjh.data.network.model.BlogDTO
import com.sateeshjh.data.network.model.OwnerDTO
import com.sateeshjh.domain.model.Blog
import com.sateeshjh.domain.model.Owner

fun List<BlogDTO>.toDomain(): List<Blog> {

    return map {
        Blog(
            id = it.id ?: "",
            image = it.image ?: "",
            likes = it.likes  ?: 0,
            owner = it.owner?.toDomain() ?: Owner("", "", "", "", ""),
            publishDate = it.publishDate ?: "",
            tags = it.tags ?: emptyList(),
            text = it.text ?: ""
        )
    }
}

fun OwnerDTO.toDomain(): Owner {
    return Owner(
        firstName ?: "", id ?: "", lastName ?: "", picture ?: "", title ?: ""
    )
}