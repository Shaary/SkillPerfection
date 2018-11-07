package com.shaary.skillperfection


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.shaary.skillperfection.data.TimeData
import kotlinx.android.synthetic.main.fragment_timer.*
import java.util.*

//TODO: save state

class TimerFragment : Fragment() {
    val TAG: String = TimerFragment::class.toString()
    lateinit var timeData: TimeData

    private var startButton: Button? = null
    private var stopButton: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_timer, container, false)
        startButton = view.findViewById(R.id.start_button)
        stopButton = view.findViewById(R.id.stop_button)
        Log.d(TAG, "button text" + startButton?.text)

        startButton!!.setOnClickListener{
            if (startButton?.text == "START") {
                timeData = TimeData(startedTime = System.currentTimeMillis() / 1000)
                timeData.isRunning = true
                startButton?.text = getString(R.string.save_button_text)
                runTimer()
                Log.d(TAG, "running")
            } else {
                startButton?.text = getString(R.string.start_button_text)
                timeData.stopTime = System.currentTimeMillis() / 1000
                resetTimer()
            }
        }

        stopButton?.setOnClickListener{ resetTimer() }

        return view
    }

    private fun runTimer() {
        var handler = Handler()

        handler.post(object : Runnable {
            override fun run() {
                var seconds: Long = timeData.seconds
                val time = getTime(seconds)
                time_text_view?.text = time

                if (timeData.isRunning) {
                    timeData.increaseSeconds()
                    //TODO: change to update ui every minute
                    handler.postDelayed(this, 1000)
                } else {
                    handler.removeCallbacks(this)
                }
            }
        })
    }

    private fun resetTimer() {
        timeData.isRunning = false
        timeData.seconds = 0
        time_text_view?.text = getString(R.string.timer_empty_text)
    }

    private fun getTime(seconds: Long): String {
        val hours = seconds / 3600
        val minutes = seconds % 3600 / 60
        val secs = seconds % 60
        return String.format(Locale.getDefault(),
                "%d:%02d:%02d", hours, minutes, secs)
    }




}
