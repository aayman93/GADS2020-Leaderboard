package com.github.aayman93.gadsleaderboard.submission

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubmissionViewModel : ViewModel() {

    val firstNameContent = MutableLiveData<String>()
    val lastNameContent = MutableLiveData<String>()
    val emailContent = MutableLiveData<String>()
    val linkToProjectContent = MutableLiveData<String>()
}