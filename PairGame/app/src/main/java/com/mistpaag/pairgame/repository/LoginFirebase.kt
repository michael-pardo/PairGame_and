package com.mistpaag.pairgame.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.mistpaag.pairgame.model.Response

class LoginFirebase {
    private val mAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

private val response = MutableLiveData<Response>()

    fun login(user:String, pass:String):MutableLiveData<Response>{
        if (user.isNotEmpty() && pass.isNotEmpty()){
            this.mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    getUser(mAuth.uid!!)
//                    loginInterface.existeUser()
                }
            }.addOnFailureListener { exception ->

                val res = Response(false, exception)
                response.value = res
//                loginInterface.mostrarMensaje(FuncsObj.verificarException(exception))
            }


        }
        return response
//        else loginInterface.mostrarMensaje("Por favor completa los campos")
    }

    /*fun getUser(uid:String){
        myref.child(Constantes.conductores).child(uid).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    val value = p0.getValue(User::class.java)
                    savePreferences(value!!)
                    if (value.pago) loginInterface.iniciarSesion(value)
                    else {
                        loginInterface.pagarMensualidad()
                    }
                }
            }
        })
    }*/
}