package com.kodiiiofc.urbanuniversity.image_downloader.presentation

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kodiiiofc.urbanuniversity.image_downloader.R
import com.kodiiiofc.urbanuniversity.image_downloader.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var dogIV: ImageView
    private lateinit var dogBTN: Button
    private lateinit var loadingPB: ProgressBar
    private lateinit var toolbar: Toolbar
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(owner = this).get(MainViewModel::class.java)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        dogIV = findViewById(R.id.iv_dog)
        dogBTN = findViewById(R.id.btn_dog)
        loadingPB = findViewById(R.id.loading_pb)
        observe()
        dogBTN.setOnClickListener {
            loadingPB.visibility = View.VISIBLE
            mainViewModel.updateDog() }
    }

    private fun observe() {
        mainViewModel.imageUrl.observe(this) {
            Glide.with(this).load(it).into(dogIV)
            loadingPB.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Выйти")?.setIcon(R.drawable.ic_menu_exit)?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            "Выйти" -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

}