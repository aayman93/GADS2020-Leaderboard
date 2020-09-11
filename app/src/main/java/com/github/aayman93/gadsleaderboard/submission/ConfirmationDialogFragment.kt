package com.github.aayman93.gadsleaderboard.submission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.databinding.DialogFragmentConfirmationBinding

class ConfirmationDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogTheme)
        isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFragmentConfirmationBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        val viewModel: SubmissionViewModel by navGraphViewModels(R.id.nav_submission)

        binding.viewModel = viewModel

        viewModel.submit.observe(viewLifecycleOwner, {submit ->
            submit?.let {
                if (submit) {
                    binding.dialogContainer.visibility = View.INVISIBLE
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    findNavController().navigate(R.id.action_confirmationDialogFragment_to_submissionFragment)
                }
                viewModel.projectSubmissionDone()
            }
        })

        viewModel.navigateToResult.observe(viewLifecycleOwner, {result ->
            result?.let {
                findNavController().navigate(ConfirmationDialogFragmentDirections
                    .actionConfirmationDialogFragmentToResultDialogFragment(result)
                )
                viewModel.navigationToResultDone()
            }
        })
        return binding.root
    }
}