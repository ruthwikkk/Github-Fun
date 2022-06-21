package com.ruthwikkk.githubapi.di

import com.ruthwikkk.githubapi.data.repositoryimpl.GithubRepositoryImpl
import com.ruthwikkk.githubapi.domain.repository.GithubRepository
import com.ruthwikkk.githubapi.domain.usecase.GetPullRequestsUseCase
import com.ruthwikkk.githubapi.domain.usecase.GetPullRequestsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class GithubModule {

    @Binds
    abstract fun bindGithubRepository(
        githubRepositoryImpl: GithubRepositoryImpl
    ): GithubRepository

    @Binds
    abstract fun bindGetPullRequestsUseCase(
        getPullRequestsUseCaseImpl: GetPullRequestsUseCaseImpl
    ): GetPullRequestsUseCase
}