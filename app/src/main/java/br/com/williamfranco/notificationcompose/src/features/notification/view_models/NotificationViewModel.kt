package br.com.williamfranco.notificationcompose.src.features.notification.view_models

import androidx.lifecycle.ViewModel
import br.com.williamfranco.notificationcompose.src.features.notification.repositories.NotificationRepository

interface NotificationViewModel {
    fun showBasicNotification()
    fun showSoundNotification()
    fun showExpandableNotification()
}

class NotificationViewModelImpl(private val repository: NotificationRepository) : ViewModel(),
    NotificationViewModel {
    override fun showBasicNotification() {
        try {
            repository.showBasicNotification()
        } catch (e: Exception) {
            println("ViewModel error: Failed to show basic notification.")
            throw e
        }
    }

    override fun showSoundNotification() {
        try {
            repository.showSoundNotification()
        } catch (e: Exception) {
            println("ViewModel error: Failed to show sound notification.")
            throw e
        }
    }

    override fun showExpandableNotification() {
        try {
            repository.showExpandableNotification()
        } catch (e: Exception) {
            println("ViewModel error: Failed to show expandable notification.")
            throw e
        }
    }
}
