package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.LeaderBoardPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_leader_board.view.*

class LeaderBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leader_board, container, false)

        val adapter = LeaderBoardPagerAdapter(this)
        view.leader_board_pager.adapter = adapter

        TabLayoutMediator(view.leader_board_tabs, view.leader_board_pager) {tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()

        return view
    }
}