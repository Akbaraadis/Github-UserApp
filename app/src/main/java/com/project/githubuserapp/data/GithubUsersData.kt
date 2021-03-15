package com.project.githubuserapp.data

import com.project.githubuserapp.R

object GithubUsersData {

    private val githubUsername = arrayOf(
        "JakeWharton",
        "amitshekhariitbhu",
        "romainguy",
        "chrisbanes",
        "tipsy",
        "ravi8x",
        "jasoet",
        "budioktaviyan",
        "hendisantika",
        "sidiqpermana"
    )

    private val githubName = arrayOf(
        "Jake Wharton",
        "AMIT SHEKHAR",
        "Romain Guy",
        "Chris Banes",
        "David",
        "Ravi Tamada",
        "Deny Prasetyo",
        "Budi Oktaviyan",
        "Hendi Santika",
        "Sidiq Permana"
    )

    private val githubAvatar = arrayOf(
        R.drawable.user1,
        R.drawable.user2,
        R.drawable.user3,
        R.drawable.user4,
        R.drawable.user5,
        R.drawable.user6,
        R.drawable.user7,
        R.drawable.user8,
        R.drawable.user9,
        R.drawable.user10
    )

    private val githubCompany = arrayOf(
        "Google, Inc.",
        "@MindOrksOpenSource",
        "Google",
        "@google working on @android",
        "Working Group Two",
        "AndroidHive | Droid5",
        "@gojek-engineering",
        "@KotlinID",
        "@JVMDeveloperID @KotlinID @IDDevOps",
        "Nusantara Beta Studio"
    )

    private val githubLocation = arrayOf(
        "Pittsburgh, PA, USA",
        "New Delhi, India",
        "California",
        "Sydney, Australia",
        "Trondheim, Norway",
        "India",
        "Kotagede, Yogyakarta, Indonesia",
        "Jakarta, Indonesia",
        "Bojongsoang - Bandung Jawa Barat",
        "Jakarta Indonesia"
    )

    private val githubRepository = arrayOf(
        102,
        37,
        9,
        30,
        56,
        28,
        44,
        110,
        1064,
        65
    )

    private val githubFollower = arrayOf(
        56995,
        5153,
        7972,
        14725,
        788,
        18628,
        277,
        178,
        428,
        465
    )

    private val githubFollowwing = arrayOf(
        12,
        2,
        0,
        1,
        0,
        3,
        39,
        23,
        61,
        10
    )

    val listData: ArrayList<GithubUsers>
        get() {
            val list = arrayListOf<GithubUsers>()
            for (position in githubName.indices){
                val github = GithubUsers()
                github.username = githubUsername[position]
                github.name = githubName[position]
                github.company = githubCompany[position]
                github.location = githubLocation[position]
                github.repository = githubRepository[position].toString()
                github.follower = githubFollower[position].toString()
                github.following = githubFollowwing[position].toString()
                github.avatar = githubAvatar[position]
                list.add(github)
            }
            return list
        }

}