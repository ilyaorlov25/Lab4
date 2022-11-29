package com.example.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RotateTest {
    @Test
    fun testRecreate() {
        val activityScenario: ActivityScenario<MainActivity> = ActivityScenario.launch(MainActivity::class.java)

        isDisplaying(idFragment1)
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        isDisplaying(idFragment1)

        toSecond()
        isDisplaying(idFragment2)
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        isDisplaying(idFragment2)

        toThird()
        isDisplaying(idFragment3)
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        isDisplaying(idFragment3)

        openAbout()
        isDisplaying(idActivityAbout)
        activityScenario.onActivity { activity ->
            activity.recreate()
        }
        isDisplaying(idActivityAbout)
    }
}
