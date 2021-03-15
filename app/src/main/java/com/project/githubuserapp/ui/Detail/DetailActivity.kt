package com.project.githubuserapp.ui.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.githubuserapp.R
import com.project.githubuserapp.data.GithubUsers
import com.project.githubuserapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_GIT = "extra_git"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val person = intent.getParcelableExtra<GithubUsers>(EXTRA_GIT) as GithubUsers

        supportActionBar?.setTitle(person.username)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDetailName.text = person.name
        binding.tvDetailCompany.text = person.company
        binding.tvDetailLocation.text = person.location
        binding.tvDetailFollowers.text = person.follower
        binding.tvDetailRepository.text = person.repository
        binding.tvDetailFollowing.text = person.following

        Glide.with(this)
            .load(intent.getIntExtra(EXTRA_IMAGE, 0))
            .apply(RequestOptions().override(80, 80))
            .into(binding.ivDetailAvatar)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}