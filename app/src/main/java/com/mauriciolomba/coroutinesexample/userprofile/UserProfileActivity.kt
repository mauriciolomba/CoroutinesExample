package com.mauriciolomba.coroutinesexample.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mauriciolomba.coroutinesexample.R

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val viewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)

        val textView = findViewById<TextView>(R.id.textView)

        viewModel.fetchUserName()
        viewModel.state.observe(this){ state ->
            when(state){
               UserProfileViewState.Loading -> textView.text = "Loading..."
               is UserProfileViewState.Success -> textView.text = "User is ${state.userName}"
            }
        }



    }
}