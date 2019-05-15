package com.aldana.ejemplo14

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        val binding: ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.score = scoreViewModel

        binding.btTeamAFreeThrow.setOnClickListener { score(true, 1) }

        binding.btTeamA2P.setOnClickListener { score(true, 2) }

        binding.btTeamA3P.setOnClickListener { score(true, 3) }

        binding.btTeamBFreeThrow.setOnClickListener { score(false, 1) }

        binding.btTeamB2P.setOnClickListener { score(false, 2) }

        binding.btTeamB3P.setOnClickListener { score(false, 3) }

        binding.btReset.setOnClickListener { resetScore() }
    }

    private fun score(isAScoring: Boolean, points: Int) {
        if (isAScoring) {
            scoreViewModel.scoreTeamA.value =
                getNewScore(
                    points,
                    scoreViewModel.scoreTeamA.value!!
                )

        } else {
            scoreViewModel.scoreTeamB.value =
                getNewScore(
                    points,
                    scoreViewModel.scoreTeamB.value!!
                )
        }
    }

    private fun resetScore() {
        scoreViewModel.scoreTeamA.value = "0"
        scoreViewModel.scoreTeamB.value = "0"
    }

    private fun getNewScore(
        points: Int,
        currentScore: String
    ) = (currentScore.toInt()
        .plus(points))
        .toString()
}


