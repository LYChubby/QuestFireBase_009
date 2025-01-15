package com.example.mvvmfirebase.navigation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvmfirebase.ui.home.pages.DetailMhsView
import com.example.mvvmfirebase.ui.home.pages.HomeScreen
import com.example.mvvmfirebase.ui.home.pages.InsertMhsView

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun PengelolaHalaman(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToitemEntry = {
                    navController.navigate(DestinasiEntry.route)
                }
            )
        }

        composable(DestinasiEntry.route) {
            InsertMhsView(
                onBack = {navController.popBackStack()},
                onNavigate = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }

        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetail.NIM) {
                    type = NavType.StringType
                }
            )
        ) {
            val nim = it.arguments?.getString(DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailMhsView(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
//                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    nim = nim,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}