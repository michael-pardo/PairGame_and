package com.mistpaag.pairgame.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class GameVMFactory(private val lista : Array<String>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameVM::class.java)){
            return GameVM() as T
        }
        throw IllegalArgumentException("Unknown View model Class")
    }

}