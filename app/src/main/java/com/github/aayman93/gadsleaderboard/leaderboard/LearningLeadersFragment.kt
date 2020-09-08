package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.aayman93.gadsleaderboard.MainViewModel
import com.github.aayman93.gadsleaderboard.databinding.FragmentLearningLeadersBinding
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.LearningLeadersAdapter

class LearningLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLearningLeadersBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.learningRecyclerView.adapter = LearningLeadersAdapter()

        return binding.root
    }
}