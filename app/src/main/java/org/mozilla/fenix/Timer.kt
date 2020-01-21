package org.mozilla.fenix

import android.util.Log

object Timer {
    private var startTimer : Long = 0

    fun getTimeElapsed(currentTime: Long) {
        if(startTimer == 0L){
            startTimer = currentTime
            Log.i("Timer", "Set up timer to ${currentTime / Math.pow(10.0,6.0)} seconds")
        }else{
            var timeDif = (currentTime - startTimer)
            Log.i("Timer", "End time was ${currentTime / Math.pow(10.0,6.0)} seconds")
            Log.i("Timer", "Time different is ${timeDif / Math.pow(10.0,6.0)} ms")
        }
    }

 }