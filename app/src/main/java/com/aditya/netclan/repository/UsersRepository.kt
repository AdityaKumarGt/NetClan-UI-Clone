package com.aditya.netclan.repository

import com.aditya.netclan.R
import com.aditya.netclan.model.User

class UsersRepository {
    private val userList: ArrayList<User> = ArrayList()

    init {
        // Populate the initial list of users
        //1
        userList.add(
            User(
                name = "KRITYUK KUMAR",
                acronymName = "KK",
                city = "Ranchi",
                position ="Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                about = "Software dev",
                distanceRange = "300-440 m",
                image = R.drawable.male_user_image1,
            ))
        //2
        userList.add(
            User(
                name = "Lalit Mehta",
                acronymName = "LM",
                city = "Ranchi",
                position ="Student",
                purposes = listOf("Coffee", "Hobbies", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                about = "Hi, all let's connect to know if our interest collide!!",
                distanceRange ="800-900 m"
            ))
        //3
        userList.add(
            User(
                name = "Piyush Kumar",
                acronymName = "PK",
                city = "Jamshedpur",
                position = "Software Engineer",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange = "1.1 KM"
            ))
        //4
        userList.add(
            User(
                name = "Bhanu Priya",
                acronymName = "BP",
                city = "Ranchi",
                position ="Content Developer",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                about = "A hard working individual with MBA as highest qualification. I am an individual with high visions and like to complete my goals with my instincts and hard work. I face challenges by using my abilities and looking forward to content writing roles.",
                distanceRange ="1.8 KM",
                image = R.drawable.user_image1
            ))
        //4
        userList.add(
            User(
                name = "Sonam Kumari",
                acronymName = "SK",
                city = "Ranchi",
                position ="Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                about = "I am Sonam Kumar, a dedicated and ambitious individual currently pursuing an MBA with a specialization in Marketing. With a deep passion for understanding consumer behavior, creating impactful campaigns, and driving business growth.",
                distanceRange ="1.9 KM",
            ))
        //5
        userList.add(
            User(
                name = "Sudarshan Kumar",
                acronymName = "SK",
                city = "Ranchi",
                position ="Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.2 KM",
            ))
        //6
        userList.add(
            User(
                name = "Saurav Kumar",
                acronymName = "SK",
                city = "Ranchi",
                position ="Android Developer",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.3 KM",
            ))
        //7
        userList.add(
            User(
                name = "Kumar Vaibhav",
                acronymName = "KV",
                city = "Ranchi",
                position ="Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.3 KM",
                image = R.drawable.male_user_image2
            ))
        //8
        userList.add(
            User(
                name = "Rohit Kumar",
                acronymName = "RK",
                city = "Ranchi",
                position ="Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.3 KM",
            ))
        //9
        userList.add(
            User(
                name = "Nishant Prakash Hritik",
                acronymName = "NH",
                city ="Ranchi",
                position = "Android Application Developer",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.5 KM",
            ))
        //9
        userList.add(
            User(
                name = "Akarshan Kumar",
                acronymName = "AK",
                city ="Bangalore",
                position = "Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.5 KM",
            ))
        //10
        userList.add(
            User(
                name = "Wajahat Hussain Ansari",
                acronymName = "WA",
                city ="Bangalore",
                position = "UIUX Designer",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.5 KM",
            ))
        //11
        userList.add(
            User(
                name = "Kriti Sonu",
                acronymName = "KS",
                city ="Ranchi",
                position = "Fresher",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="2.6 KM",
            ))
        //12
        userList.add(
            User(
                name = "Priya Rani",
                acronymName = "PR",
                city ="Bengaluru",
                position = "Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                about = "I like to express my feelings thoughts and ideas through work. I always keep " +
                        "looking for opportunities to enhance my skills, to learn something new " +
                        "everyday so that I can tap my potential to the fullest. I have confidence in my ability" +
                        " to come up with interesting ideas for content writing and marketing I am thoughtful, imaginative," +
                        " and creative and have ability to work under pressure and multitask. I will be ve very sincere towards" +
                        " my work and give my all.",
                distanceRange ="2.7 KM",
            ))
        //13
        userList.add(
            User(
                name = "Adarsh Kumar",
                acronymName = "AK",
                city ="Ranchi",
                position = "Fresher Graduate",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="3.1 KM",
            ))
        //14
        userList.add(
            User(
                name = "Mimansa Dubey",
                acronymName = "MD",
                city ="Ranchi",
                position = "Student",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="3.6 KM",
            ))
        //15
        userList.add(
            User(
                name = "Madhuresh Ranjan",
                acronymName = "KS",
                city ="Ranchi",
                position = "UI and UX Designer",
                purposes = listOf("Coffee", "Business", "Friendship"),
                status = "Hi community! I am open to new connections \"\uD83D\uDE0A\"",
                distanceRange ="3.3 KM",
            ))


    }

    // Expose the user list to the outside
    fun getUserList(): ArrayList<User> {
        return userList
    }

}