package com.delicious.parkingspy.Nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.delicious.parkingspy.login.ui.SignInUi
import com.delicious.parkingspy.login.ui.SignUpUi
import com.delicious.parkingspy.login.viewmodels.SignInState
import com.delicious.parkingspy.login.viewmodels.SignInViewModel
import com.delicious.parkingspy.login.viewmodels.SignUpState
import com.delicious.parkingspy.login.viewmodels.SignUpViewModel

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login") {
       composable("Login") {
           SignInUi(viewModel = SignInViewModel(
               initialState = SignInState()),
               navController = navController
           )
       }

        composable("Register") {
            SignUpUi(viewModel = SignUpViewModel(
                initialState = SignUpState()
            ),
                navController = navController
            )
        }
    }
}