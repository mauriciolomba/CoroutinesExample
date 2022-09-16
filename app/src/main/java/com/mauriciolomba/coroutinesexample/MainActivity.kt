package com.mauriciolomba.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.mauriciolomba.coroutinesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.state.observe(this, ::onStateChanged)

        binding.buttonRun.setOnClickListener{
            viewModel.runHeavyWork()
        }
    }

    private fun onStateChanged(mainViewState: MainViewState) {
        val message = when (mainViewState){
            MainViewState.Idle -> R.string.main_state_idle
            MainViewState.Loading -> R.string.main_state_loading
            MainViewState.Executing -> R.string.main_state_executing
            MainViewState.Success -> R.string.main_state_success
        }
        binding.textviewState.setText(message)
    }
}