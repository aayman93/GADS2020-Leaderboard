package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.aayman93.gadsleaderboard.databinding.FragmentLeaderBoardBinding
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.LeaderBoardPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LeaderBoardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLeaderBoardBinding.inflate(inflater)

        val adapter = LeaderBoardPagerAdapter(this)
        binding.leaderBoardPager.adapter = adapter

        TabLayoutMediator(binding.leaderBoardTabs, binding.leaderBoardPager) {tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()

        return binding.root
    }
}