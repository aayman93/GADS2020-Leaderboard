package com.github.aayman93.gadsleaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aayman93.gadsleaderboard.models.LearningLeader
import com.github.aayman93.gadsleaderboard.models.SkillIqLeader
import com.github.aayman93.gadsleaderboard.network.GadsApi
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _navigateToLeaderBoard = MutableLiveData<Boolean>()
    val navigateToLeaderBoard: LiveData<Boolean>
        get() = _navigateToLeaderBoard

    private val _learningLeaders = MutableLiveData<List<LearningLeader>>()
    val learningLeaders: LiveData<List<LearningLeader>>
        get() = _learningLeaders

    private val _skillIqLeaders = MutableLiveData<List<SkillIqLeader>>()
    val skillIqLeaders: LiveData<List<SkillIqLeader>>
        get() = _skillIqLeaders

    init {
        getTopLearners()
    }

    private fun getTopLearners() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val learningLeadersDeferred = async { GadsApi.retrofitService.getLearningLeaders() }
                    val skillIqLeadersDeferred = async { GadsApi.retrofitService.getSkillIqLeaders() }
                    _learningLeaders.value = learningLeadersDeferred.await()
                    _skillIqLeaders.value = skillIqLeadersDeferred.await()
                }
            } catch (e: Exception) {
                _learningLeaders.value = ArrayList()
                _skillIqLeaders.value = ArrayList()
            }
            _navigateToLeaderBoard.value = true
        }
    }

    fun navigationToLeaderBoardDone() {
        _navigateToLeaderBoard.value = false
    }

}