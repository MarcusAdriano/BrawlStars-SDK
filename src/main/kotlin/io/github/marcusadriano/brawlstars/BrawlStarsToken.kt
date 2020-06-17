package io.github.marcusadriano.brawlstars

inline class BSToken(private val value: String) {

    val bearer: String
        get() = this.value

}