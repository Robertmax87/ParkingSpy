package com.delicious.parkingspy.login.viewmodels

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel


data class SignInState(
    val email: String = "",
    val password: String = ""
) : MavericksState

class SignInViewModel(initialState: SignInState) : MavericksViewModel<SignInState>(initialState) {

    fun updateUserEmail(email: String) = setState {
        copy(
            email = email
        )
    }

    fun updateUserPassword(password: String) = setState {
        copy(
            password = password
        )
        validateUser(email, password)
    }

    fun validateUser(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
        //TODO: Validate in database, create validation logic
    }
}