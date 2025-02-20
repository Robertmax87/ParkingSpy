package com.delicious.parkingspy.login.viewmodels

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.delicious.parkingspy.Nav.Screen
import com.delicious.parkingspy.login.structs.SignUpBundle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

data class SignUpState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val dateOfBirth: LocalDate = LocalDate.now()
)



class SignUpViewModel : ViewModel() {

    private val signUpState = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = signUpState

    fun updateUserFirstName(firstName: String) {
        signUpState.value = signUpState.value.copy(firstName = firstName)
    }

    fun updateUserLastName(lastName: String) {
        signUpState.value = signUpState.value.copy(lastName = lastName)
    }

    fun updateUserEmail(email: String) {
        signUpState.value = signUpState.value.copy(email = email)
    }

    fun updateDateOfBirth(dob: LocalDate) {
        signUpState.value = signUpState.value.copy(dateOfBirth = dob)
    }

    private fun bundleIntoSignUpData(
    firstName: String,
    lastName: String,
    email: String,
    dob: LocalDate
    ): SignUpBundle {
       return SignUpBundle(
            firstName = firstName,
           lastName = lastName,
           email = email,
           dob = dob
        )
    }

    @Composable
    fun navigateToSignIn(){
        val navController = rememberNavController()
        bundleIntoSignUpData(
           firstName =  state.value.firstName,
            lastName = state.value.lastName,
            email = state.value.email,
            dob = state.value.dateOfBirth
        )
        NavHost(navController = navController, startDestination = Screen.SignUpScreen.router) {
            composable(route = Screen.SignUpScreen.router) {

            }
        }
    }
}