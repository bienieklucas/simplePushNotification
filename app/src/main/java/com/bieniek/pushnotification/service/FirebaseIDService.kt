package com.bieniek.pushnotification.service

import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * @author Lucas Bieniek
 */
class FirebaseIDService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()
        //Send new token to your backend
    }

}