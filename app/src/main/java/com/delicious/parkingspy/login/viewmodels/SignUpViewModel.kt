package com.delicious.parkingspy.login.viewmodels

import androidx.lifecycle.ViewModel
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
}