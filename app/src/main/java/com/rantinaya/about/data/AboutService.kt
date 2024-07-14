package com.rantinaya.about.data

interface AboutServiceInterface {
    fun getAboutMembers() : List<AboutMember>
}
class AboutService : AboutServiceInterface {
    override fun getAboutMembers(): List<AboutMember> {
        return listOf(
            AboutMember(
                name = "Jefferson Guaman",
                email = "Jefferson56@gmail.com",
                phone = "+593 96 963 9668",
                links = Triple("https://gmail.com","https://www.linkedin.com/","https://www.github.com/")
            ),
            AboutMember(
                name = "Cosme Guerrero",
                email = "Cosmeguerrero218@gmail.com",
                phone = "+593 98 634 7845",
                links = Triple("https://gmail.com","https://www.linkedin.com/","https://www.github.com/")
            ),
            AboutMember(
                name = "Bryan Calapucha",
                email = "Bryan721@gmail.com",
                phone = "+593 99 728 6773",
                links = Triple("https://gmail.com","https://www.linkedin.com/","https://www.github.com/")
            ),
            AboutMember(
                name = "Jose Astudillo",
                email = "JoseAstudillo17@gmail.com",
                phone = "+593 98 844 6954",
                links = Triple("https://gmail.com","https://www.linkedin.com/","https://www.github.com/")
            ),
            AboutMember(
                name = "Andres Viera",
                email = "VieraAndres123@gmail.com",
                phone = "+593 96207 6118",
                links = Triple("https://gmail.com","https://www.linkedin.com/","https://www.github.com/")
            ),
        )
    }
}