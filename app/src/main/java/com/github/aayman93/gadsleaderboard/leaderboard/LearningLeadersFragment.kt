package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.LearningLeadersAdapter
import com.github.aayman93.gadsleaderboard.models.Data
import kotlinx.android.synthetic.main.fragment_learning_leaders.view.*

class LearningLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_learning_leaders, container, false)

        val adapter = LearningLeadersAdapter()
        view.learning_recycler_view.adapter = adapter

        adapter.data = Data.learningLeaders.sortedByDescending { it.hours }

        return view
    }
}