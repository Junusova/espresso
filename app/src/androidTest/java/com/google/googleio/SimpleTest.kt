package com.google.googleio

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.equalTo
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.google.googleio.fixtures.LoginVariables

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)

class SimpleTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_00_userAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        equalTo(listOf("mytaxi.android_demo", appContext.packageName))
    }

    @Test
    fun test_01_Authorization() {
        onView(withId(R.id.cameraType))
                .check(matches(isDisplayed()))
                .perform(clearText())
                .perform(typeText(LoginVariables.username))
                .check(matches(isDisplayed()))
                .perform(clearText())
                .perform(typeText(LoginVariables.password))
        onView(withText("Upload"))

    }
}