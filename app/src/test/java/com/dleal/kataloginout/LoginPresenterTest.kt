package com.dleal.kataloginout

import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    @Mock
    lateinit var authView: AuthView

    private val loginValidator = LoginValidator()

    @Mock
    lateinit var logoutValidator: LogoutValidator

    private lateinit var loginPresenter : AuthPresenter

    @Before
    fun setUp(){
        loginPresenter = AuthPresenter(authView, loginValidator, logoutValidator)
    }

    @Test
    fun showsLogoutFormWhenCredentialsAreValid() {
        givenValidCredentials()

        loginPresenter.onLogInButtonClick()

        verify(authView, times(1)).hideLogInForm()
        verify(authView, times(1)).showLogOutForm()
    }

    @Test
    fun showsErrorWhenCredentialsAreInvalid() {
        givenInvalidCredentials()

        loginPresenter.onLogInButtonClick()

        verify(authView, times(1)).showError("Invalid credentials")
    }

    @Test
    fun showsLogInFormWhenUserLogsOut(){
        givenWillLogOut()

        loginPresenter.onLogOutButtonClick()

        verify(authView, times(1)).clearLogInForm()
        verify(authView, times(1)).showLogInForm()
        verify(authView, times(1)).hideLogOutForm()
    }

    @Test
    fun doesNothingWhenUserClicksLogsOutButTimeIsOdd(){
        givenWillNotLogOut()

        loginPresenter.onLogOutButtonClick()

        verify(authView, times(0)).clearLogInForm()
        verify(authView, times(0)).showLogInForm()
        verify(authView, times(0)).hideLogOutForm()
    }

    private fun givenValidCredentials() {
        whenever(authView.getUsername()).thenReturn(VALID_USERNAME)
        whenever(authView.getPassword()).thenReturn(VALID_PASSWORD)
    }

    private fun givenInvalidCredentials() {
        whenever(authView.getUsername()).thenReturn(INVALID_USERNAME)
        whenever(authView.getPassword()).thenReturn(INVALID_PASSWORD)
    }

    private fun givenWillLogOut(){
        whenever(logoutValidator.performLogout()).thenReturn(true)
    }

    private fun givenWillNotLogOut(){
        whenever(logoutValidator.performLogout()).thenReturn(false)
    }
}