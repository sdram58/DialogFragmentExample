package com.catata.dialogfragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.catata.dialogfragmentexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val my_login: LoginDialogFragment = LoginDialogFragment(){
            binding.tvResultDialog.text = it.toString()
        }
        binding.tvShowDialog.setOnClickListener {
            binding.tvResultDialog.text = ""

            my_login.show(supportFragmentManager,"My Login Dialog")
        }

    }
}