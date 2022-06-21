package com.ruthwikkk.githubapi.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.ruthwikkk.githubapi.data.model.PullRequest
import com.ruthwikkk.githubapi.domain.usecase.GetPullRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPullRequestsUseCaseImpl: GetPullRequestsUseCase
): ViewModel() {
    suspend fun getPullRequests(): Flow<PagingData<PullRequest>> {
            return getPullRequestsUseCaseImpl("google", "ExoPlayer", "closed")
        }

}