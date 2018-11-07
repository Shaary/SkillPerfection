package com.shaary.skillperfection.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class TimeData (
        @PrimaryKey (autoGenerate = true)
        var seconds: Long = 0,
        var isRunning: Boolean = false,
        val startedTime: Long,
        var stopTime: Long = 0,
        val timeSpent: Int = 0) {

    fun increaseSeconds(): Long = seconds++

}