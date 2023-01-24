package com.sateeshjh.blogapplication.screens.home

import com.sateeshjh.domain.model.Blog

data class HomeState (
    var isLoading: Boolean = false,
    var data: List<Blog>? = null,
    var error: String = "n"
)