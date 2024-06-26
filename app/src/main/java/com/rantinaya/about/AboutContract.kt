package com.rantinaya.about

import com.rantinaya.about.data.AboutMember

interface AboutContract {
    fun setMembers(members : List<AboutMember>)
    fun openWeb(url : String)
}