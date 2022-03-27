package com.example.challengeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeapp.databinding.ActivityCreateBinding

class CreateActivity : AppCompatActivity() {

    private var mBinding: ActivityCreateBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}