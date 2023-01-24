package com.sateeshjh.blogapplication.navigation

sealed class NavigationItem(val route: String) {

    object Home: NavigationItem("Home")
    object Details: NavigationItem("Details")
}
