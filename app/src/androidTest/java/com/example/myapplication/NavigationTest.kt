package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Before
    fun launch() {
        launchActivity<MainActivity>()
    }

    @Test
    fun testFirst() {
        isDisplaying(idFragment1)
    }

    @Test
    fun testToSecond() {
        toSecond()
        isDisplaying(idFragment2)
    }

    @Test
    fun testToThird() {
        toSecond()
        toThird()
        isDisplaying(idFragment3)
    }

    @Test
    fun testSecondToFirst() {
        toSecond()
        toFirst()
        isDisplaying(idFragment1)
    }

    @Test
    fun testThirdToSecond() {
        toSecond()
        toThird()
        toSecond()
        isDisplaying(idFragment2)
    }

    @Test
    fun testThirdToFirst() {
        toSecond()
        toThird()
        toFirst()
        isDisplaying(idFragment1)
    }

    /**
     * Navigation up
     */

    @Test
    fun testNavUpInFirst() {
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description)).check(doesNotExist())
    }

    @Test
    fun testNavUpInSecond() {
        toSecond()
        pressBackUpNav()
        isDisplaying(idFragment1)
        // BS?
    }

    @Test
    fun testNavUpInThird() {
        toSecond()
        toThird()
        pressBackUpNav()
        isDisplaying(idFragment2)
        pressBackUpNav()
        isDisplaying(idFragment1)
        // BS?
    }
}