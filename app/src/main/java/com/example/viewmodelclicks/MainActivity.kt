package com.example.viewmodelclicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viewmodelclicks.ui.theme.ViewModelClicksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel by viewModels<MainViewModel>()
        setContent {
            ViewModelClicksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    
                    Body(myViewModel = MainViewModel())

                }
            }
        }
    }

    @Composable
    fun Body(myViewModel: MainViewModel){ //al crear la función hay que instanciar la ViewModel
        val clicksValue: Int by myViewModel.clicksValue.observeAsState(0) //tenemos que permitir que lea los cambios de la variable que hemos creado en ViewModel

        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Button(onClick = {
                myViewModel.onIncrementClicked() //llamamos a la función de la ViewModel
            }) {
                Text(text = "Incrementa")
            }

            Button(onClick = {
                myViewModel.onDecrementClicked() //llamamos a la función de la ViewModel
            }) {
                Text(text = "Decrementa")
            }
            
            Text(text = "$clicksValue") //imprimimos el valor a través de la función que recibe los datos de la ViewModel

        }
    }

}

