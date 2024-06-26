package com.rantinaya.home

interface HomeContract {
    fun navigateToAbout()
    fun navigateToLogin()
    fun navigateToProducts( canton : String)
    fun onDestroy()
    fun navigateToServices(canton: String)
}