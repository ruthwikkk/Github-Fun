package com.ruthwikkk.githubapi.data.network

sealed class ResultOf<out R> {
    data class Success<out R>(val value: R) : ResultOf<R>()
    object Loading : ResultOf<Nothing>()
    data class Failure(val throwable: Throwable?) : ResultOf<Nothing>()
}