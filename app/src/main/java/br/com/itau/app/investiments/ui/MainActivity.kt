package br.com.itau.app.investiments.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.itau.app.investiments.ui.navigation.BottomNavigationBar
import br.com.itau.app.investiments.ui.navigation.Screen
import br.com.itau.app.investiments.ui.navigation.SetupNavigation
import br.com.itau.app.ui_components.theme.ItauInvestmentsTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()

            ItauInvestmentsTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    SetupNavigation(navController)
                    Spacer(modifier = Modifier.weight(1f))
                    BottomNavigationBar(navController, listOf(Screen.Home, Screen.StocksAlert))
                }
            }
        }
    }
}
