package com.example.challengeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val challengeList = arrayListOf(
            Challenge(0, R.drawable.water, "Drink Water", "하루에 2리터 이상 물마시기!", true)
        )

        binding.rvChallenge.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvChallenge.setHasFixedSize(true)

        binding.rvChallenge.adapter = ChallengeAdapter(challengeList)

        // 플로팅 버튼 클릭
        binding.btnPlus.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
    }
}