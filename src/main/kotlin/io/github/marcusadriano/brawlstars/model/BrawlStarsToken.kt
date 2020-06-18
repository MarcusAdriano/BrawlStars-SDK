package io.github.marcusadriano.brawlstars.model

inline class BrawlStarsToken(private val value: String) {

    val bearer: String
        get() = this.value

}