package io.github.marcusadriano.brawlstars.example

import io.github.marcusadriano.brawlstars.BrawlStars
import io.github.marcusadriano.brawlstars.model.Result

fun <T> printResult(result: Result<T>) {
    when(result) {
        is Result.Success -> println(result.data)
        is Result.Error -> {
            println("Error ==> ${result.data.reason}")
        }
    }
}

fun main(args: Array<String>) {
    val token = args[0]
    BrawlStars.setup(token)
    val service = BrawlStars.service()
    val result = service.battleLog("#9UV9UG9J")
    printResult(result)
}

