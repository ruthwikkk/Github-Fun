package com.ruthwikkk.githubapi.domain.usecase

import androidx.paging.PagingData
import com.ruthwikkk.githubapi.data.model.PullRequest
import kotlinx.coroutines.flow.Flow

interface GetPullRequestsUseCase {
    suspend operator fun invoke(owner: String, repo: String, state: String): Flow<PagingData<PullRequest>>
}