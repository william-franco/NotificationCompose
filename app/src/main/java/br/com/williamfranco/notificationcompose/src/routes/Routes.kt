package br.com.williamfranco.notificationcompose.src.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import br.com.williamfranco.notificationcompose.src.dependency_injector.*
import br.com.williamfranco.notificationcompose.src.features.notification.views.*

@Composable
fun RoutesApp(dependencies: DependencyInjector) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "notificationView"
    ) {
        composable("notificationView") {
            NotificationView(dependencies.notificationViewModel)
        }
    }
}
