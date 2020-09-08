package com.github.aayman93.gadsleaderboard.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.github.aayman93.gadsleaderboard.MainViewModel
import com.github.aayman93.gadsleaderboard.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        val viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.navigateToLeaderBoard.observe(viewLifecycleOwner, {shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_splashFragment_to_leaderBoardFragment)
                viewModel.navigationToLeaderBoardDone()
            }
        })
        return view
    }
}