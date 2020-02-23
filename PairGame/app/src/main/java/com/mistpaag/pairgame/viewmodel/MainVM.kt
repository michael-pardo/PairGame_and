package com.mistpaag.pairgame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.mistpaag.pairgame.model.Response
import com.mistpaag.pairgame.model.User
import com.mistpaag.pairgame.repository.LoginFirebase
import com.mistpaag.pairgame.utils.Const
import com.mistpaag.pairgame.utils.Instancias

class MainVM: ViewModel() {


    val response : LiveData<Response>
        get() = _response

    var user = ""
    var passwd = ""
    private var _response = MutableLiveData<Response>()

    init {

    }



    private val mAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val myref by lazy {
        Instancias.dbinst.getReference()
    }

    fun login() {
        if (user.isNotEmpty() && passwd.isNotEmpty()){
            this.mAuth.signInWithEmailAndPassword(user, passwd).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val res = Response(true, "Ok}")
                    _response.value = res
//                    getUser(mAuth.uid!!)
//                    loginInterface.existeUser()
                }
            }.addOnFailureListener { exception ->

                val res = Response(false, "Error ${exception.localizedMessage}")
                _response.value = res
            }


        }else{
            val res = Response(false, "Please fill all inputs")
            _response.value = res
        }
    }

    fun getUser(uid:String){
        myref.child(Const.users).child(uid).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    val value = p0.getValue(User::class.java)
//                    savePreferences(value!!)

                }
            }
        })
    }









}