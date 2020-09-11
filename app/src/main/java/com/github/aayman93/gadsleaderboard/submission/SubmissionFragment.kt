package com.github.aayman93.gadsleaderboard.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.navigation.ui.setupWithNavController
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.databinding.FragmentSubmissionBinding

class SubmissionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSubmissionBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        val viewModel: SubmissionViewModel by navGraphViewModels(R.id.nav_submission)

        binding.viewModel = viewModel

        binding.submissionToolbar.apply {
            setupWithNavController(findNavController())
            title = ""
            setNavigationIcon(R.drawable.ic_arrow_back)
        }

        viewModel.navigateToConfirmation.observe(viewLifecycleOwner, {shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.action_submissionFragment_to_confirmationDialogFragment)
                viewModel.navigationToConfirmationDone()
            }
        })

        return binding.root
    }
}