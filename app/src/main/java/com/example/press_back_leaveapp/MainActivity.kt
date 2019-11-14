package com.example.press_back_leaveapp

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

     private var backPressedTime: Long = 0
    private var backToast: Toast? = null
    // when we press 2 time then our app will be close;
    // backPressed vari contain our time in miilli seconds;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onBackPressed() {
        // if our press time is equal to system time the our app will be shutdown;
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast!!.cancel()
            super.onBackPressed()
            return
        } else {
            backToast = Toast.makeText(baseContext, "Press again to exit", Toast.LENGTH_SHORT)
            backToast!!.show()
        }

        backPressedTime = System.currentTimeMillis()
    }
}
