package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.SkillIqLeadersAdapter
import com.github.aayman93.gadsleaderboard.models.Data
import kotlinx.android.synthetic.main.fragment_skill_iq_leaders.view.*

class SkillIqLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false)

        val adapter = SkillIqLeadersAdapter()

        view.skill_iq_recycler_view.adapter = adapter

        adapter.data = Data.skillIqLeaders.sortedByDescending { it.score }

        return view
    }
}