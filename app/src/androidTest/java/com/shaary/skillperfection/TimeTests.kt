package com.shaary.skillperfection

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.shaary.skillperfection.data.Session
import com.shaary.skillperfection.data.TrackingDatabase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class TimeTests {

    val testTime = Session(startedTime = 10000000000000000)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        val db = Room.databaseBuilder(appContext, TrackingDatabase::class.java, "TimeDb").build()
        db.sessionDao().insert(testTime)
        val returnedTime = db.sessionDao().getTimeById(testTime.id)
        assertEquals(testTime, returnedTime)
    }
}
