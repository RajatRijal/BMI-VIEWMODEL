package com.example.bmi

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi.ui.theme.BMITheme
import androidx.compose.runtime.mutableStateOf
import kotlin.properties.ReadWriteProperty
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.example.bmi.MyViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi.ui.theme.BMITheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Bmi()
                }
            }
        }
    }
}

@Composable
fun Bmi (myViewModel: MyViewModel =  MyViewModel()) {

    Column {
        Text(
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )

        OutlinedTextField(
            value=myViewModel.heightInput,
            onValueChange = {myViewModel.changeHeightInput(it)},
            label = { Text( stringResource(R.string.height))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value= myViewModel.weightInput,
            onValueChange = {myViewModel.changeWeightInput(it)},
            label = { Text(stringResource(R.string.weight))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text(text = stringResource(R.string.result,myViewModel.bmi))


    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMITheme {
        Bmi()
    }
}