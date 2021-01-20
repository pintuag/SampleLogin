package com.example.samplelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.samplelogin.service.ServiceCreator
import com.example.samplelogin.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    lateinit var loginButton : Button
    lateinit var editText : EditText

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        editText = findViewById(R.id.editLoginText)

        setOnClickListener()

    }

    private fun setOnClickListener() {

        loginButton.setOnClickListener {
            retrofitService()
        }
    }

    private fun retrofitService() {
        val retrofitService = ServiceCreator.createService()
        val jsonObject = JSONObject().apply {
            put(Constants.MOBILE, editText.text.toString())
        }
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofitService.getSignInUser(Constants.getRequestBody(jsonObject))
            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_SHORT)
                                .show()
                    } else {
                        Log.e("errpr", " k ")
                    }
                } catch (e : HttpException) {
                    Log.e("", "Exception ${e.message}")
                } catch (e : Throwable) {
                    Log.e("", "Exception ${e.message}")
                }
            }
        }
    }
}