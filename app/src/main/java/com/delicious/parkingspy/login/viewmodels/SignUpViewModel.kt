package com.delicious.parkingspy.login.viewmodels

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.delicious.parkingspy.login.structs.SignUpBundle
import java.time.LocalDate

data class SignUpState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val dateOfBirth: LocalDate = LocalDate.now(),
    val password: String = "",
    val userName: String = "",
) : MavericksState



class SignUpViewModel(initialState: SignUpState) : MavericksViewModel<SignUpState>(initialState) {

    fun updateUserFirstName(firstName: String) = setState {
        copy(
            firstName = firstName
        )
    }

fun updateUserLastName(lastName: String) = setState {
    copy(
        lastName = lastName
    )
}

    fun updateUserEmail(email: String) = setState {
        copy(
            email = email
        )
    }

    fun updateDateOfBirth(dob: LocalDate) = setState {
        copy(
            dateOfBirth = dob
        )
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
}