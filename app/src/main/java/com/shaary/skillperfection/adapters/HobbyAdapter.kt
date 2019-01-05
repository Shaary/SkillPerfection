package com.shaary.skillperfection.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shaary.skillperfection.R
import com.shaary.skillperfection.data.Skill

class HobbyAdapter(val hobbies: ArrayList<Skill>): RecyclerView.Adapter<HobbyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.hobby_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = hobbies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hobbyName.text = hobbies[position].name
        //TODO: convert long to normal time format
        holder.hobbyTime.text = hobbies[position].time.toString()

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val hobbyName: TextView = itemView.findViewById(R.id.hobby_name)
        val hobbyTime: TextView = itemView.findViewById(R.id.hobby_time)
    }
}