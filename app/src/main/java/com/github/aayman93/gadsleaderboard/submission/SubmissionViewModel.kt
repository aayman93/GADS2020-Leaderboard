package com.github.aayman93.gadsleaderboard.submission

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aayman93.gadsleaderboard.network.GoogleFormsApi
import kotlinx.coroutines.launch

class SubmissionViewModel : ViewModel() {

    val firstNameContent = MutableLiveData<String>()
    val lastNameContent = MutableLiveData<String>()
    val emailContent = MutableLiveData<String>()
    val linkToProjectContent = MutableLiveData<String>()

    private val _navigateToConfirmation = MutableLiveData<Boolean>()
    val navigateToConfirmation: LiveData<Boolean>
        get() = _navigateToConfirmation

    private val _submit = MutableLiveData<Boolean>()
    val submit: LiveData<Boolean>
        get() = _submit

    private val _navigateToResult = MutableLiveData<Boolean>()
    val navigateToResult: LiveData<Boolean>
        get() = _navigateToResult

    fun onSubmitButtonClicked() {
        _navigateToConfirmation.value = true
    }

    fun navigationToConfirmationDone() {
        _navigateToConfirmation.value = false
    }

    fun onConfirmButtonClicked() {
        val firstName = firstNameContent.value
        val lastName = lastNameContent.value
        val email = emailContent.value
        val linkToProject = linkToProjectContent.value

        _submit.value = true

        if (!(firstName.isNullOrEmpty() || lastName.isNullOrEmpty() ||
                    email.isNullOrEmpty() || linkToProject.isNullOrEmpty())) {
            submitProject(email, firstName, lastName, linkToProject)
        } else {
            _navigateToResult.value = false
        }
    }

    fun onCloseButtonClicked() {
        _submit.value = false
    }

    private fun submitProject(
        email: String,
        firstName: String,
        lastName: String,
        linkToProject: String
    ) {
        viewModelScope.launch {
            try {
                GoogleFormsApi.retrofitService.submitProject(
                    email,
                    firstName,
                    lastName,
                    linkToProject
                )
                _navigateToResult.value = true
            } catch (e: Exception) {
                _navigateToResult.value = false
            }
        }
    }

    fun navigationToResultDone() {
        _navigateToResult.value = null
    }

    fun projectSubmissionDone() {
        _submit.value = null
    }
}