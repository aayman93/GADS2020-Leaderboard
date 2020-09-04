package com.github.aayman93.gadsleaderboard.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.aayman93.gadsleaderboard.R
import kotlinx.android.synthetic.main.fragment_splash.view.*

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        // Just a way to navigate to the leader board for now
        view.gads_logo.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_leaderBoardFragment)
        }

        return view
    }
}