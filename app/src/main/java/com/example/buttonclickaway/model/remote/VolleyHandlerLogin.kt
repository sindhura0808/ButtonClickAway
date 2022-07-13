package com.learning.mvpregistrationapp.model.remote

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.buttonclickaway.model.remote.data.UserLogin
import org.json.JSONObject

class VolleyHandlerLogin(private val context: Context) {

    private var requestQueueLogin: RequestQueue = Volley.newRequestQueue(context)

    fun loginUser(user: UserLogin, callback: OperationalCallback): String {

        val url = Constants.BASE_URL + Constants.LOGIN_END_POINT
        val data = JSONObject()
        var message: String? = null
        var status:Int=-1
        data.put("email_id", user.emailId)
        data.put("password", user.password)
        Log.e("tag", "Welcome")
        // Toast.makeText(context, "login Successfull", Toast.LENGTH_SHORT).show()
        val request = JsonObjectRequest(

            Request.Method.POST, url, data,
            { responses: JSONObject ->
                Log.e("tag", "Welcome")
                var  status = responses.getInt("status")
                message = responses.getString("message")
                Log.e("tag", "message is $message")
                if (status == 0) {
                    Log.e("tag", "Welcome")
                   // Toast.makeText(context, "login Successfull001 status= ${status}", Toast.LENGTH_SHORT).show()
                    Log.i("tag", message.toString())
                    callback.onSuccess(message.toString(), status)
                }
            },
            { error: VolleyError ->
                error.printStackTrace()
                Log.i("tag", "${error.printStackTrace()}")
                callback.onFailure(message.toString(),status)
            })
        requestQueueLogin.add(request)
        return message.toString()
    }
}