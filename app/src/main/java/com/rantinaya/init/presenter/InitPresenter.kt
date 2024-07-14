package com.rantinaya.init.presenter

import com.rantinaya.init.InitContract

class InitPresenter(var initView: InitContract?) {

    fun navigateToHome() {
        initView?.navigateToHome()
    }

    fun openWeb() {
        initView?.openWeb()
    }

    fun onDestroy() {
        initView = null
    }
}