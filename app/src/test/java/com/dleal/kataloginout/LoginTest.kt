package com.dleal.kataloginout

import org.junit.Assert.assertTrue
import org.junit.Test

class LoginTest {

    private val testCases = listOf(
        TestCase("Valid username and password", VALID_USERNAME, VALID_PASSWORD, true),
        TestCase("Invalid username and valid password", INVALID_USERNAME, VALID_PASSWORD, false),
        TestCase("Valid username and invalid password", VALID_USERNAME, INVALID_PASSWORD, false),
        TestCase("Invalid username and password", INVALID_USERNAME, INVALID_PASSWORD, false),
        TestCase("Empty username and valid password", EMPTY, VALID_PASSWORD, false),
        TestCase("Valid username and empty password", VALID_USERNAME, EMPTY, false),
        TestCase("Empty username and invalid password", EMPTY, INVALID_PASSWORD, false),
        TestCase("Invalid username and empty password", INVALID_USERNAME, EMPTY, false),
        TestCase("Empty username and empty password", EMPTY, EMPTY, false)
    )

    @Test
    fun returnsProperLoginValue() {
        val loginValidator = givenLoginValidator()

        testCases.forEach {testCase ->
            with(testCase){
                assertTrue(message, loginValidator.performLogin(username, password) == expectedResult)
            }
        }
    }

    private fun givenLoginValidator() = LoginValidator()
}

class TestCase(
    val message: String,
    val username: String,
    val password: String,
    val expectedResult: Boolean
)

private const val EMPTY = ""

private const val VALID_USERNAME = "admin"
private const val INVALID_USERNAME = "wrong"

private const val VALID_PASSWORD = "admin"
private const val INVALID_PASSWORD = "1234"