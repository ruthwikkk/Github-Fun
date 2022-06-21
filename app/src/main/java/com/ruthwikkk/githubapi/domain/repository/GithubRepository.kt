package com.ruthwikkk.githubapi.domain.repository

import androidx.paging.PagingSource
import com.ruthwikkk.githubapi.data.model.PullRequest

interface GithubRepository {
    fun getPullRequests(
        owner: String,
        repo: String,
        state: String
    ): PagingSource<Int, PullRequest>
}