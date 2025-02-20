package com.delicious.parkingspy.Nav

sealed class Screen (val router: String) {
    object SignUpScreen: Screen("Sign Up")
    object SignInScreen: Screen("Sign In")
}