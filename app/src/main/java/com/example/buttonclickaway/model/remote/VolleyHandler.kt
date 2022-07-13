package com.learning.mvpregistrationapp.model.remote

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.buttonclickaway.model.remote.data.User
import com.learning.mvpregistrationapp.model.remote.Constants.BASE_URL
import com.learning.mvpregistrationapp.model.remote.Constants.REGISTRATION_END_POINT
import org.json.JSONObject

class VolleyHandler(private val context: Context) {

    private var requestQueue: RequestQueue = Volley.newRequestQueue(context)

    fun registerUser(user: User, callback: OperationalCallback): String {
        val url = BASE_URL + REGISTRATION_END_POINT
        val data = JSONObject()
        var message: String? = null
        val status:Int=-1

        data.put("full_name", user.fullName)
        data.put("mobile_no", user.mobileNo)
        data.put("email_id", user.emailId)
        data.put("password", user.password)

        val request = JsonObjectRequest(Request.Method.POST, url, data,
            { response: JSONObject ->
                val status = response.getInt("status")
                message = response.getString("message")
                Log.i("tag", message.toString())
                callback.onSuccess(message.toString(),status)
            }, { error: VolleyError ->
                error.printStackTrace()
                Log.i("tag", "${error.printStackTrace()}")
                callback.onFailure(message.toString(),status)
            })
        requestQueue.add(request)
        return message.toString()
    }


}