package br.com.williamfranco.notificationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme

import br.com.williamfranco.notificationcompose.src.dependency_injector.*
import br.com.williamfranco.notificationcompose.src.routes.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dependencies = DependencyInjector(this)

        setContent {
            MaterialTheme {
                RoutesApp(dependencies)
            }
        }
    }
}
