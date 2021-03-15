package com.project.githubuserapp.ui.Main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.githubuserapp.R
import com.project.githubuserapp.data.GithubUsers
import com.project.githubuserapp.ui.Detail.DetailActivity

class MainAdapter (val listGithub: ArrayList<GithubUsers>, private val context: Context) : RecyclerView.Adapter<MainAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvCompany: TextView = itemView.findViewById(R.id.tv_item_company)
        var tvLocation: TextView = itemView.findViewById(R.id.tv_item_location)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_shoes, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val github = listGithub[position]
        Glide.with(holder.itemView.context)
            .load(github.avatar)
            .apply(RequestOptions().override(80, 120))
            .into(holder.imgPhoto)
        holder.tvName.text = github.name
        holder.tvCompany.text = github.company
        holder.tvLocation.text = github.location

        holder.itemView.setOnClickListener {

            val intentGithub = Intent(context, DetailActivity::class.java)
            intentGithub.putExtra(DetailActivity.EXTRA_GIT, github)
            intentGithub.putExtra(DetailActivity.EXTRA_IMAGE,github.avatar)
            holder.itemView.context.startActivity(intentGithub)
        }
    }

    override fun getItemCount(): Int {
        return listGithub.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubUsers)
    }
}