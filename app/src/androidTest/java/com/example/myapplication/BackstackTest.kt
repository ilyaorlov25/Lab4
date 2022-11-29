package com.example.myapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackstackTest {
    @get:Rule
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun launch() {
        launchActivity<MainActivity>()
    }

    @Test
    fun testSimple2() {
        toSecond()
        pressBack()
        isDisplaying(idFragment1)
    }

    @Test
    fun testSimple3() {
        toSecond()
        toThird()
        pressBack()
        isDisplaying(idFragment2)
        pressBack()
        isDisplaying(idFragment1)
    }

    @Test
    fun testExit_1() {
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_1() {
        toSecond()
        toFirst()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_b() {
        toSecond()
        pressBackUnconditionally()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_3_b_b() {
        toSecond()
        toThird()
        pressBackUnconditionally()
        pressBackUnconditionally()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_3_Ab_b_b_b() {
        toSecond()
        toThird()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        pressBackUnconditionally()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_3_1() {
        toSecond()
        toThird()
        toFirst()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_3_2_b() {
        toSecond()
        toThird()
        toSecond()
        pressBackUnconditionally()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_3_2_1() {
        toSecond()
        toThird()
        toSecond()
        toFirst()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_Ab_b_b() {
        toSecond()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testExit_1_2_3_b_Ab_b_b() {
        toSecond()
        toThird()
        pressBackUnconditionally()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testBackstackWithNavUp_1_2_3_Ab() {
        toSecond()
        toThird()
        openAbout()
        pressBackUpNav()
        pressBackUpNav()
        pressBackUpNav()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun testBackstackWithNavUp_1_2_3_2() {
        toSecond()
        toThird()
        toSecond()
        pressBackUpNav()
        pressBackUnconditionally()
        assertTrue(mainActivityRule.scenario.state == Lifecycle.State.DESTROYED)
    }
}