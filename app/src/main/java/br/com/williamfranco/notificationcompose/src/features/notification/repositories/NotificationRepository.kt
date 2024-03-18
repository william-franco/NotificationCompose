package br.com.williamfranco.notificationcompose.src.features.notification.repositories

import br.com.williamfranco.notificationcompose.src.features.notification.services.NotificationService

interface NotificationRepository {
    fun showBasicNotification()
    fun showSoundNotification()
    fun showExpandableNotification()
}

class NotificationRepositoryImpl(private val service: NotificationService) :
    NotificationRepository {
    override fun showBasicNotification() {
        try {
            service.showBasicNotification()
        } catch (e: Exception) {
            println("Repository error: Failed to show basic notification.")
            throw e
        }
    }

    override fun showSoundNotification() {
        try {
            service.showSoundNotification()
        } catch (e: Exception) {
            println("Repository error: Failed to show sound notification.")
            throw e
        }
    }

    override fun showExpandableNotification() {
        try {
            service.showExpandableNotification()
        } catch (e: Exception) {
            println("Repository error: Failed to show expandable notification.")
            throw e
        }
    }
}
