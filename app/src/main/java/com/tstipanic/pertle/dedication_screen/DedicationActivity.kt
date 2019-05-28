package com.tstipanic.pertle.dedication_screen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tstipanic.pertle.R
import com.tstipanic.pertle.learning_screen.LearningActivity
import kotlinx.android.synthetic.main.activity_dedication.*

class DedicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dedication)
        startButton.setOnClickListener { goToLearningActivity() }
    }



    private fun goToLearningActivity() {
        val intent =  Intent(this, LearningActivity::class.java)
        startActivity(intent)
    }


}
