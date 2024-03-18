package br.com.williamfranco.notificationcompose.src.dependency_injector

import android.content.Context

import br.com.williamfranco.notificationcompose.src.features.notification.repositories.*
import br.com.williamfranco.notificationcompose.src.features.notification.services.*
import br.com.williamfranco.notificationcompose.src.features.notification.view_models.*

class DependencyInjector(private val context: Context) {
    // Services
    private val notificationService: NotificationService = NotificationServiceImpl(context)
    // Repositories
    private val notificationRepository: NotificationRepository = NotificationRepositoryImpl(notificationService)
    // ViewModels
    val notificationViewModel: NotificationViewModel = NotificationViewModelImpl(notificationRepository)
}
