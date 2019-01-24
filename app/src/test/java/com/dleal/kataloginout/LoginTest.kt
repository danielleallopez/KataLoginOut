package com.dleal.kataloginout

import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginTest {

    @Mock
    lateinit var timeProvider: TimeProvider

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

        testCases.forEach { testCase ->
            with(testCase) {
                assertTrue(message, loginValidator.performLogin(username, password) == expectedResult)
            }
        }
    }

    @Test
    fun logsOutWhenCurrentTimeIsEven() {
        givenEvenTime()
        val logoutValidator = givenLogoutValidator()

        assertTrue("Logs out when time is even", logoutValidator.performLogout())
    }

    @Test
    fun doesNotLogOutWhenCurrentTimeIsOdd() {
        givenOddTime()
        val logoutValidator = givenLogoutValidator()

        assertFalse("Logs out when time is even", logoutValidator.performLogout())
    }

    private fun givenLoginValidator() = LoginValidator()
    private fun givenLogoutValidator() = LogoutValidator(timeProvider)

    private fun givenEvenTime() {
        whenever(timeProvider.getTimeMillis()).thenReturn(EVEN_TIME)
    }

    private fun givenOddTime() {
        whenever(timeProvider.getTimeMillis()).thenReturn(ODD_TIME)
    }
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

private const val EVEN_TIME = 123456L
private const val ODD_TIME = 12345L