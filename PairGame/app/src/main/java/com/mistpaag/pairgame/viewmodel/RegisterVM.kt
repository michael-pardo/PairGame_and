package com.mistpaag.pairgame.viewmodel

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.mistpaag.pairgame.model.Response
import kotlinx.coroutines.*
import okhttp3.Dispatcher


class RegisterVM: ViewModel(){

    private var viewModelJob = Job()
    private val ioScope = CoroutineScope(Dispatchers.IO )

    private val mAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    val response : LiveData<Response>
        get() = _response
    private var _response = MutableLiveData<Response>()

    fun register(name: String, email: String, passwd: String, tag: Int) {
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                ioScope.launch {
                    mAuth.createUserWithEmailAndPassword(email, passwd)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                updateProfile(name, tag)
                                val res = Response(true, "User")
                                _response.value = res
                            } else {
                                Log.d("lol", task.exception?.localizedMessage.toString())
                                val res =
                                    Response(false, task.exception?.localizedMessage.toString())
                                _response.value = res
                            }
                        }
                }
            }
        }
    }

    fun updateProfile(name: String, tag: Int) {
        val user = FirebaseAuth.getInstance().currentUser
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(name)
            .setPhotoUri(Uri.parse(tag.toString()))
            .build()

        user!!.updateProfile(profileUpdates)
            .addOnCompleteListener(OnCompleteListener<Void?> { task ->
                if (task.isSuccessful) {

                }
            })
    }

    init {

    }
}