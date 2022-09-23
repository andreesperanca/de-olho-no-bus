package com.andreesperanca.deolhonobus.data.remote

import com.andreesperanca.deolhonobus.util.Resource

//class ApiCallClass(private val service: RetrofitService) {
//
//    object Authenticator {
//        var credential = ""
//    }
//
//    suspend fun getAuthInApi() {
//        val auth = service.getAuthInAPI()
//        val credential = auth.headers().get("Set-Cookie")
//        credential?.let {
//            authentication(it)
//        }
//    }
//
//    private fun authentication(auth: String) {
//        Authenticator.credential = auth
//    }
//
//    suspend inline fun <T> apiCall(action: () -> Resource<T>): Resource<T> {
//        return try {
//            action()
//        } catch (e: Exception) {
//            if (e.message == "HTTP 401 Unauthorized") {
//                getAuthInApi()
//                action()
//            } else {
//                Resource.Error(e.message ?: "")
//            }
//        }
//    }
//}