package com.codingwithmitch.cleanmultimodule.presentation.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.codingwithmitch.cleanmultimodule.R

sealed class BottomNavItem(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
    val screen: Screen,
){
    object Home: BottomNavItem(
        Icons.Filled.Home,
        R.string.screen_home,
        Screen.Home
    )

    object Account: BottomNavItem(
        Icons.Filled.AccountBox,
        R.string.screen_account,
        Screen.Account
    )
}


fun Screen.getBottomNavItem(): BottomNavItem{
    return when(this){
        is Screen.Home -> {
            BottomNavItem.Home
        }
        is Screen.Account -> {
            BottomNavItem.Account
        }
    }
}









