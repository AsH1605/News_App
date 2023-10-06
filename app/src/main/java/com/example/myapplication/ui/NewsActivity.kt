package com.example.myapplication.ui

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.db.ArticleDatabase
import com.example.myapplication.repository.NewsRepository

import com.google.android.material.bottomnavigation.BottomNavigationView


class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val newsRepository=NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory=NewsViewModelProviderFactory(application,newsRepository)
        viewModel= ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]
        setContentView(R.layout.activity_news)

        val newsNavHostFragment=findViewById<FrameLayout>(R.id.newsNavHostFragment)
        val navController: NavController = newsNavHostFragment.findNavController()

        val navView=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        navView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}