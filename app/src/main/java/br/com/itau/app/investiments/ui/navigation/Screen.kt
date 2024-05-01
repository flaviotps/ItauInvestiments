package br.com.itau.app.investiments.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.vector.ImageVector

const val HOME = "Home"
const val STOCKS_ALERT = "StocksAlert"

sealed class Screen(
    val route: String,
    val icon: ImageVector
) {
    data object Home : Screen(route = HOME, Icons.Default.Home)
    data object StocksAlert : Screen(route = STOCKS_ALERT, Icons.Filled.Notifications)
}