package com.aditya.netclan.repository

import com.aditya.netclan.R
import com.aditya.netclan.model.BusinessUser
import com.aditya.netclan.model.User

class BusinessUserRepository {
    private val userList: ArrayList<BusinessUser> = ArrayList()

    init {
        // Populate the initial list of users
        //1
        userList.add(
            BusinessUser(
                name = "Khushboo Kumari",
                acronymName = "KK",
                city = "Ranchi",
                distanceRange = "2.8 KM",
                position = listOf("Intern", "1 year of experience"),
                status = "Hi community! I am available at your services! \"\uD83D\uDE0A\"",
            )
        )
        //2
        userList.add(
            BusinessUser(
                name = "Karan Rana",
                acronymName = "KR",
                image = R.drawable.business_male_user,
                city = "Ranchi",
                distanceRange = "3.1 KM",
                position = listOf("App Developer", "2 years of experience"),
                status = "Hi community! I am available at your services! \"\uD83D\uDE0A\"",
            )
        )
        //3
        userList.add(
            BusinessUser(
                name = "Rakhi Chauhan",
                acronymName = "RC",
                city = "Ranchi",
                distanceRange = "4.7 KM",
                position = listOf("SDE", "2 years of experience"),
                status = "Hi community! I am available at your services! \"\uD83D\uDE0A\"",
            )
        )
        //4
        userList.add(
            BusinessUser(
                name = "Anurag Tyagi",
                acronymName = "AT",
                city = "Ranchi",
                distanceRange = "2.7 KM",
                position = listOf("UIUX Desiger", "3 years of experience"),
                status = "Hi community! I am available at your services! \"\uD83D\uDE0A\"",
            )
        )
        //5
        userList.add(
            BusinessUser(
                name = "Raushan Patel",
                acronymName = "AT",
                city = "Ranchi",
                distanceRange = "2.4 KM",
                position = listOf("Freelancer", "1 year of experience"),
                status = "Hi community! I am available at your services! \"\uD83D\uDE0A\"",
            )
        )





    }

    // Expose the user list to the outside
    fun getUserList(): ArrayList<BusinessUser> {
        return userList
    }

}