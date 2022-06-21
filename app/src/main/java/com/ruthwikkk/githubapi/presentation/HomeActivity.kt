package com.ruthwikkk.githubapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.ruthwikkk.githubapi.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private var adapter: PullRequestAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        adapter = PullRequestAdapter()
        findViewById<RecyclerView>(R.id.rv_pulls).adapter = adapter


        viewModel.apply {
            lifecycleScope.launchWhenResumed {
                getPullRequests().collectLatest {
                    adapter?.submitData(it)
                }
            }
        }
    }
}