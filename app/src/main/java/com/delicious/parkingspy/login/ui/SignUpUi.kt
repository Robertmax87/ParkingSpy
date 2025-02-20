package com.delicious.parkingspy.login.ui

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.delicious.parkingspy.R
import com.delicious.parkingspy.login.viewmodels.SignUpViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Preview
@Composable
fun SignUpUi(viewModel: SignUpViewModel = viewModel(),
             navController: NavController = rememberNavController()
) {
    val signUpState = viewModel.state.collectAsState().value
    val context = LocalContext.current
    val dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy")
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            viewModel.updateDateOfBirth(LocalDate.of(year, month + 1, dayOfMonth))
        },
        signUpState.dateOfBirth.year,
        signUpState.dateOfBirth.monthValue - 1,
        signUpState.dateOfBirth.dayOfMonth
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.a_stylized_logo_for_an_app_called__parking_spy___t),
            contentDescription = "Header Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        OutlinedTextField(
            value = signUpState.firstName,
            onValueChange = { viewModel.updateUserFirstName(it) },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = signUpState.lastName,
            onValueChange = { viewModel.updateUserLastName(it) },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = signUpState.email,
            onValueChange = { viewModel.updateUserEmail(it) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = signUpState.email,
            onValueChange = { viewModel.updateUserEmail(it) },
            label = { Text("Choose UserName") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = signUpState.email,
            onValueChange = { viewModel.updateUserEmail(it) },
            label = { Text("Choose Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
        ) {
            Text("Select Date of Birth")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
        ) {
            Text("Press to continue")
        }

    }
}