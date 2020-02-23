package com.mistpaag.pairgame.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

object Instancias {
    val dbinst = FirebaseDatabase.getInstance()
    val auth = FirebaseAuth.getInstance()
    var primerPlano = true
    val remoteConfig = FirebaseRemoteConfig.getInstance()
}