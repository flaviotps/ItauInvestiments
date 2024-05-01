package br.com.itau.app.investiments.ui.navigation

import android.app.Application
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.itau.app.home.ui.home.Home
import br.com.itau.app.home.ui.home.HomeViewModel
import br.com.itau.app.home.ui.home.HomeViewModelFactory
import br.com.itau.app.home.data.local.InvestmentLocal
import br.com.itau.app.home.data.local.InvestmentLocalDataSource
import br.com.itau.app.home.data.repository.InvestmentsRepository
import br.com.itau.app.network.NetworkClient
import br.com.itau.app.home.data.remote.InvestmentService
import br.com.itau.app.home.data.remote.InvestmentRemoteDataSource
import br.com.itau.app.stocks.ui.alert.Stocks
import br.com.itau.app.stocks.ui.alert.StocksAlertViewModel


@Composable
fun SetupNavigation(navHostController: NavHostController) {

    val application = LocalContext.current.applicationContext as Application

    val stocksAlertViewModel: StocksAlertViewModel = viewModel()

    val investmentRemoteService = NetworkClient(InvestmentService::class.java)
    val investmentLocalService = InvestmentLocal(application)
    val investmentRemoteDataSource = InvestmentRemoteDataSource(investmentRemoteService)
    val investmentLocalDataSource = InvestmentLocalDataSource(investmentLocalService)
    val investmentsRepository = InvestmentsRepository(investmentRemoteDataSource, investmentLocalDataSource)
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(investmentsRepository))


    NavHost(navController = navHostController, Screen.Home.route, Modifier.fillMaxHeight(0.92f)) {
        composable(Screen.Home.route) {
            Home(homeViewModel)
        }
        composable(Screen.StocksAlert.route) {
            Stocks(stocksAlertViewModel)
        }
    }
}