package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton


class MainActivity : AppCompatActivity()
{
    lateinit var loginButton: LoginButton
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(getApplicationContext())
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.login_button)
        callbackManager=CallbackManager.Factory.create()

        loginButton.registerCallback(callbackManager,object:FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {



            }

            override fun onCancel() {

            }

            override fun onError(error: FacebookException?) {

            }
        })
    }
}