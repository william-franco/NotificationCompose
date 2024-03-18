package br.com.williamfranco.notificationcompose.src.features.notification.views

import android.Manifest
import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.williamfranco.notificationcompose.src.features.notification.view_models.*
import com.google.accompanist.permissions.*

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun NotificationView(viewModel: NotificationViewModel) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val postNotificationPermission = rememberPermissionState(Manifest.permission.POST_NOTIFICATIONS)

        LaunchedEffect(key1 = true ){
            if(!postNotificationPermission.status.isGranted){
                postNotificationPermission.launchPermissionRequest()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Notification")
                },
            )
        },
        content = {padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {
                        viewModel.showBasicNotification()
                    },
                ) {
                    Text("Show basic notification")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        viewModel.showSoundNotification()
                    },
                ) {
                    Text("Show sound notification")
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        viewModel.showExpandableNotification()
                    },
                ) {
                    Text("Show expandable notification")
                }
            }
        },
    )
}
