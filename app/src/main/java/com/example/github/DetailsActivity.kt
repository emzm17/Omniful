package com.example.github

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.github.data.GResponse
import com.example.github.data.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val repo: Item =intent.getParcelableExtra("REPO")!!
        stars_tv.text=repo.stargazers_count.toString()+" Stars"
        fork_tv.text=repo.forks_count.toString()+" forks"
        Picasso.get().load(repo.owner!!.avatar_url).into(image_view)
        repo_name_tv.text=repo.name
        author_name_tv.text=repo.full_name
        webview.webViewClient = WebViewClient()
        webview.loadUrl(repo.html_url)
        webview.settings.javaScriptEnabled = true
        webview.settings.setSupportZoom(true)
    }
}