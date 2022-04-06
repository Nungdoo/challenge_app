package com.example.challengeapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.util.Log

class ChallengeAdapter(val challengeList: ArrayList<Challenge>) : RecyclerView.Adapter<ChallengeAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {
                val curPos = adapterPosition
                val id = challengeList.get(curPos).id
                //Toast.makeText(parent.context, "${id}", Toast.LENGTH_SHORT).show()

                val intent = Intent(itemView.context, DetailActivity::class.java)

                Log.d("CustomViewHolder", "")
                Log.d("icon : ", challengeList.get(curPos).icon)
                Log.d("title : ", challengeList.get(curPos).title)
                Log.d("contents : ", challengeList.get(curPos).contents)

                //intent.putExtra("id", challengeList.get(curPos).id)
                intent.putExtra("icon", challengeList.get(curPos).icon)
                intent.putExtra("title", challengeList.get(curPos).title)
                intent.putExtra("contents", challengeList.get(curPos).contents)
                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
    }

    override fun onBindViewHolder(holder: ChallengeAdapter.CustomViewHolder, position: Int) {
        Log.d("onBindViewHolder", "")
        Log.d("icon : ", challengeList.get(position).icon)
        Log.d("title : ", challengeList.get(position).title)
        Log.d("contents : ", challengeList.get(position).contents)

        holder.icon.text = challengeList.get(position).icon
        holder.title.text = challengeList.get(position).title
        holder.contents.text = challengeList.get(position).contents
    }

    override fun getItemCount(): Int {
        return challengeList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val id: Int, val icon: Int, val title: String, val contents: String, val push: Boolean
        val icon = itemView.findViewById<TextView>(R.id.tv_icon)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val contents = itemView.findViewById<TextView>(R.id.tv_contents)
    }
}