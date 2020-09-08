package com.github.aayman93.gadsleaderboard.leaderboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.aayman93.gadsleaderboard.MainViewModel
import com.github.aayman93.gadsleaderboard.databinding.FragmentSkillIqLeadersBinding
import com.github.aayman93.gadsleaderboard.leaderboard.adapters.SkillIqLeadersAdapter

class SkillIqLeadersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSkillIqLeadersBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        binding.skillIqRecyclerView.adapter = SkillIqLeadersAdapter()

        return binding.root
    }
}