package com.example.challengeapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var mBinding: ActivityDetailBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(!intent.hasExtra("id")) {
            Toast.makeText(this, "챌린지 정보가 없습니다.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, intent.getStringExtra("id"), Toast.LENGTH_SHORT).show()
        }
    }
}