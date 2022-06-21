package com.ruthwikkk.githubapi.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ruthwikkk.githubapi.data.model.PullRequest

class PullRequestsPagingSource(private val api: Api, private val owner: String, private val repo: String,
                               private val state: String):
    PagingSource<Int, PullRequest>() {

    override fun getRefreshKey(state: PagingState<Int, PullRequest>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PullRequest> {
        return try {
            val nextPageNumber = params.key ?: 1
            val list = api.getPullRequests(owner,repo, state, nextPageNumber)
            return LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}