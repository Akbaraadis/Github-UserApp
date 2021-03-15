package com.project.githubuserapp.ui.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.githubuserapp.R
import com.project.githubuserapp.data.GithubUsers
import com.project.githubuserapp.data.GithubUsersData
import com.project.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list: ArrayList<GithubUsers> = arrayListOf()
    private var backButtonCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle("Github Users")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHeroes.setHasFixedSize(true)

        list.addAll(GithubUsersData.listData)
        showRecyclerCardView()

    }

    private fun showRecyclerCardView() {
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = MainAdapter(list, this)
        binding.rvHeroes.adapter = cardViewHeroAdapter
    }

    override fun onBackPressed() {
        if (backButtonCount >= 1) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                "Tekan tombol kembali sekali lagi untuk keluar.",
                Toast.LENGTH_SHORT
            ).show()
            backButtonCount++
        }
    }
}