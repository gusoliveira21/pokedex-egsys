package egsys.pokedex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import egsys.pokedex.ui.screens.appArea.details.Details
import egsys.pokedex.ui.screens.appArea.home.Home
import egsys.pokedex.ui.screens.apresentation.Splash

@Composable
fun Presentation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { Splash(navController = navController) }
        composable("mainContent") { MainContent() }
    }
}

@Composable
fun NavHostMainContent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Home(navController) }
        composable(
            "details/{param}",
            arguments = listOf(navArgument("param") { type = NavType.StringType })
        ) { backStackEntry ->
            val param = backStackEntry.arguments?.getString("param")
            Details(navController, param)
        }
    }
}