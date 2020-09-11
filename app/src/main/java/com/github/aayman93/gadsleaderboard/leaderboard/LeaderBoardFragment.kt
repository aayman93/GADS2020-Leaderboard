package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.aayman93.gadsleaderboard.MainViewModel
import com.github.aayman93.gadsleaderboard.R
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

        binding.lifecycleOwner = viewLifecycleOwner

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.viewModel = viewModel

        val adapter = LeaderBoardPagerAdapter(this)
        binding.leaderBoardPager.adapter = adapter

        TabLayoutMediator(binding.leaderBoardTabs, binding.leaderBoardPager) {tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()

        viewModel.navigateToSubmission.observe(viewLifecycleOwner, {shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_leaderBoardFragment_to_submissionFragment)
                viewModel.navigationToSubmissionDone()
            }
        })

        return binding.root
    }
}