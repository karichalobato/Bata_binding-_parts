package com.aldana.ejemplo14

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    val scoreTeamA = MutableLiveData<String>()
    val scoreTeamB = MutableLiveData<String>()

    init {
        scoreTeamA.value = "0"
        scoreTeamB.value = "0"
    }
}