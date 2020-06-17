package io.github.marcusadriano.brawlstars

inline class BrawlStarsToken(private val value: String) {

    val bearer: String
        get() = this.value

}