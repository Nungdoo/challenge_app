package com.example.challengeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChallengeAdapter(val challengeList: ArrayList<Challenge>) : RecyclerView.Adapter<ChallengeAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                // 상세페이지로 이동
            }
        }
    }

    override fun onBindViewHolder(holder: ChallengeAdapter.CustomViewHolder, position: Int) {
        holder.icon.setImageResource(challengeList.get(position).icon)
        holder.title.text = challengeList.get(position).title
        holder.contents.text = challengeList.get(position).contents
    }

    override fun getItemCount(): Int {
        return challengeList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val id: Int, val icon: Int, val title: String, val contents: String, val push: Boolean
        val icon = itemView.findViewById<ImageView>(R.id.iv_icon)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val contents = itemView.findViewById<TextView>(R.id.tv_contents)
    }
}