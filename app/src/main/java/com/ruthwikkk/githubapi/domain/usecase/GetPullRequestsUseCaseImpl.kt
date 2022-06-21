package com.ruthwikkk.githubapi.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ruthwikkk.githubapi.data.model.PullRequest
import com.ruthwikkk.githubapi.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPullRequestsUseCaseImpl @Inject constructor(
    private val githubRepository: GithubRepository
): GetPullRequestsUseCase {
    override suspend fun invoke(
        owner: String,
        repo: String,
        state: String
    ): Flow<PagingData<PullRequest>> {
        return Pager(config = PagingConfig(pageSize = 10, prefetchDistance = 5),
            pagingSourceFactory = {
                githubRepository.getPullRequests(owner,repo, state)
            }
        ).flow
    }
}