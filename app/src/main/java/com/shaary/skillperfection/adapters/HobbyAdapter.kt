package com.shaary.skillperfection.adapters

import android.support.v7.recyclerview.extensions.ListAdapter
import android.content.Intent
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shaary.skillperfection.R
import com.shaary.skillperfection.SkillActivity
import com.shaary.skillperfection.data.Skill

class HobbyAdapter : ListAdapter<Skill, HobbyAdapter.ViewHolder>(DIFF_CALLBACK){

    private var listener: onItemClickListener? = null

    interface onItemClickListener {
        fun onItemClick(skill: Skill)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.hobby_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO: convert long to normal time format
        val currentSkill = getItem(position)
        holder.bind(currentSkill)
    }

    fun getSkillAt(position: Int): Skill {
        return getItem(position)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val hobbyName: TextView = itemView.findViewById(R.id.hobby_name)
        private val hobbyTime: TextView = itemView.findViewById(R.id.hobby_time)

        lateinit var skill: Skill

        fun bind(skill: Skill) {
            this.skill = skill
            hobbyName.text = skill.name
            hobbyTime.text = skill.time.toString()
        }

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener!!.onItemClick(getItem(position))
                }
            }
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Skill>() {
            override fun areItemsTheSame(oldSkill: Skill, newSkill: Skill): Boolean {
                return oldSkill.id == newSkill.id
            }

            override fun areContentsTheSame(oldSkill: Skill, newSkill: Skill): Boolean {
                return oldSkill.name == newSkill.name &&
                        oldSkill.time == newSkill.time &&
                        oldSkill.id == newSkill.id
            }
        }
    }
}
