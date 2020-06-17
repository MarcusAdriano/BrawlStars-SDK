package io.github.marcusadriano.model

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val data: io.github.marcusadriano.model.Error) : Result<Error>()
}