package com.shaary.skillperfection.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "session", foreignKeys = [(ForeignKey(entity = Skill::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("skillId"),
        onDelete = ForeignKey.CASCADE))])
class Session (
        @PrimaryKey (autoGenerate = true) var id: Long = 0,
        var seconds: Long = 0,
        var isRunning: Boolean = false,
        val startedTime: Long,
        var stopTime: Long = 0,
        val timeSpent: Int = 0,
        val skillId: Long) {

    fun increaseSeconds(): Long = seconds++

}