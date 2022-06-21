package com.ruthwikkk.githubapi.data.repositoryimpl

import androidx.paging.PagingSource
import com.ruthwikkk.githubapi.data.model.PullRequest
import com.ruthwikkk.githubapi.data.network.Api
import com.ruthwikkk.githubapi.data.network.PullRequestsPagingSource
import com.ruthwikkk.githubapi.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val api: Api
): GithubRepository {
    override fun getPullRequests(owner: String, repo: String, state: String): PagingSource<Int, PullRequest> {
        return PullRequestsPagingSource(api, owner, repo, state)
    }
}