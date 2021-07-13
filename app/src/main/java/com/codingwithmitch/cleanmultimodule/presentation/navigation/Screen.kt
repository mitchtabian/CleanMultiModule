package com.codingwithmitch.cleanmultimodule.presentation.navigation

import androidx.annotation.StringRes
import com.codingwithmitch.cleanmultimodule.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
){
    object Home: Screen("home", R.string.screen_home)

    object Account: Screen("account", R.string.screen_account)
}