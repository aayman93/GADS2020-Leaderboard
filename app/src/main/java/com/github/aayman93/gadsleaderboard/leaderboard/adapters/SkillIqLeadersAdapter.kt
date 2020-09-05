package com.github.aayman93.gadsleaderboard.leaderboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.aayman93.gadsleaderboard.databinding.ListItemSkillIqLeadersBinding
import com.github.aayman93.gadsleaderboard.models.SkillIqLeader

class SkillIqLeadersAdapter : RecyclerView.Adapter<SkillIqLeadersAdapter.ViewHolder>() {

    var data = listOf<SkillIqLeader>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(private val binding: ListItemSkillIqLeadersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SkillIqLeader) {
            binding.skillIqLeader = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemSkillIqLeadersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size
}