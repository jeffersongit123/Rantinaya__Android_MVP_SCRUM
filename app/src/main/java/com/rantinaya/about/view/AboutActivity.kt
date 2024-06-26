package com.rantinaya.about.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityAboutBinding
import com.rantinaya.about.AboutContract
import com.rantinaya.about.data.AboutMember
import com.rantinaya.about.presenter.AboutPresenter

class AboutActivity : AppCompatActivity() , AboutContract {
    private lateinit var binding : ActivityAboutBinding
    private val presenter = AboutPresenter(this)
    private lateinit var adapter : AboutAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.getMembers()
    }

    override fun setMembers(members: List<AboutMember>) {
        adapter = AboutAdapter(members.toMutableList())
        adapter.openWeb = {presenter.openWeb(it)}
        binding.rvMembers.adapter = adapter
    }

    override fun openWeb(url: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        try {
            startActivity(intent)
        }catch (e : Exception) {

        }

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}