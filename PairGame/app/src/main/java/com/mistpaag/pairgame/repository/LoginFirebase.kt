package com.mistpaag.pairgame.repository

import com.google.firebase.auth.FirebaseAuth

class LoginFirebase {
    private val mAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    fun datosLogin(user:String, pass:String):Unit{
        if (user.isNotEmpty() && pass.isNotEmpty()){
            this.mAuth.signInWithEmailAndPassword(user, pass).addOnCompleteListener { task ->
                if (task.isSuccessful){
//                    getUser(mAuth.uid!!)
//                    loginInterface.existeUser()
                }
            }.addOnFailureListener { exception ->
//                loginInterface.mostrarMensaje(FuncsObj.verificarException(exception))
            }

        }
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