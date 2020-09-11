package com.github.aayman93.gadsleaderboard.submission

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.github.aayman93.gadsleaderboard.R
import com.github.aayman93.gadsleaderboard.databinding.DialogFragmentResultBinding

class ResultDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.DialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DialogFragmentResultBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        val result = ResultDialogFragmentArgs.fromBundle(requireArguments()).result

        if (result) {
            binding.resultImage.setImageResource(R.drawable.ic_success)
            binding.resultMessage.text = getString(R.string.submission_successful)
        }

        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        findNavController().navigate(R.id.action_resultDialogFragment_to_submissionFragment)
    }
}