package com.rantinaya.about.presenter

import com.rantinaya.about.AboutContract
import com.rantinaya.about.data.AboutService

class AboutPresenter(var view : AboutContract?) {

    private val service = AboutService()

    fun getMembers() {
        view?.setMembers(service.getAboutMembers())
    }

    fun openWeb(url : String) {
        view?.openWeb(url)
    }

    fun onDestroy() {
        view = null
    }
}