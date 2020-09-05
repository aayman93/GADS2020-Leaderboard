package com.github.aayman93.gadsleaderboard.leaderboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.aayman93.gadsleaderboard.databinding.ListItemLearningLeadersBinding
import com.github.aayman93.gadsleaderboard.models.LearningLeader

class LearningLeadersAdapter : RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder>() {

    var data = listOf<LearningLeader>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(private val binding: ListItemLearningLeadersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LearningLeader) {
            binding.learningLeader = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemLearningLeadersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size
}