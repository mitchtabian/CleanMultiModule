package com.codingwithmitch.cleanmultimodule.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.account.AccountScreen
import com.codingwithmitch.account.presentation.account.AccountViewModel
import com.codingwithmitch.cleanmultimodule.presentation.theme.AppTheme
import com.codingwithmitch.home.presentation.HomeScreen
import com.codingwithmitch.home.presentation.home.HomeViewModel

@Composable
fun Navigation(){
    AppTheme(
        darkTheme = false
    ) {
        val navController = rememberNavController()
        val destinations = remember { listOf(Screen.Home, Screen.Account)}
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    destinations.forEach { screen ->
                        val bottomNavItem = screen.getBottomNavItem()
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    bottomNavItem.icon,
                                    contentDescription = stringResource(id = bottomNavItem.contentDescription)
                                )
                            },
                            label = { Text(stringResource(screen.resourceId)) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    // on the back stack as users select items
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(navController = navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
                composable(route = Screen.Home.route) { backStackEntry ->
                    val viewModel: HomeViewModel = hiltViewModel()
                    HomeScreen(viewModel.value)
                }
                composable(route = Screen.Account.route) { backStackEntry ->
                    val viewModel: AccountViewModel = hiltViewModel()
                    AccountScreen(viewModel.value)
                }
            }
        }

    }
}














