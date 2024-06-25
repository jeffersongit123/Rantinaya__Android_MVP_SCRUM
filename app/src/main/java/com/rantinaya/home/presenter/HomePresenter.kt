package com.rantinaya.home.presenter

import com.rantinaya.home.HomeContract

class HomePresenter(private var homeView: HomeContract?) {

    fun navigateToAbout() {
        homeView?.navigateToAbout()
    }

    fun navigateToProduct(canton : String) {
        homeView?.navigateToProducts(canton)
    }
    fun navigateToService(canton : String) {
        homeView?.navigateToServices(canton)
    }
    fun onDestroy() {
        homeView = null
    }
}