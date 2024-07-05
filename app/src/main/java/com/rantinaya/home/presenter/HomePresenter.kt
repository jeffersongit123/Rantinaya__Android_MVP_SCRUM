package com.rantinaya.home.presenter

import com.rantinaya.home.HomeContract

class HomePresenter(var homeView: HomeContract?) {

    fun navigateToAbout() {
        homeView?.navigateToAbout()
    }
<<<<<<< HEAD
    fun navigateToLogin() {
        homeView?.navigateToLogin()
    }
=======

>>>>>>> Logout
    fun navigateToProduct(canton : String) {
        homeView?.navigateToProducts(canton)
    }
    fun navigateToService(canton : String) {
        homeView?.navigateToServices(canton)
    }
    fun onDestroy() {
        homeView = null
    }
<<<<<<< HEAD
=======
    fun openDialogLogout() {
        homeView?.openDialogLogout()
    }

>>>>>>> Logout
}