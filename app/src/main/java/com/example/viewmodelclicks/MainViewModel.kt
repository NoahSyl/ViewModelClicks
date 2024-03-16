package com.example.viewmodelclicks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() { //la clase debe de heredar de ViewModel -> :

    private val _clicksValue = MutableLiveData <Int> (0) //definimos una variable privada LiveData con constructor de tipo y valor inicial
    val clicksValue = _clicksValue //almacenamos en variable pública

    fun onIncrementClicked(){
        _clicksValue.value = //para utilizar el valor de la variable hay que llamar a .value
            _clicksValue.value?.plus(1) //Kotlin debe asegurarse de la integridad de datos por lo que hay que usar un '?', no vale hacer +1
    }

    fun onDecrementClicked(){
        _clicksValue.value = _clicksValue.value?.minus(1)
    }
}