package io.github.marcusadriano.brawlstars

import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.github.marcusadriano.brawlstars.service.impl.BrawlStarsServiceImpl
import java.lang.RuntimeException

object BrawlStars {

    private var service: BrawlStarsService? = null

    @JvmStatic fun setup(token: String) {
        service = BrawlStarsServiceImpl(BrawlStarsToken(token))
    }

    @JvmStatic fun service(): BrawlStarsService {
        if (service == null) {
            throw RuntimeException("Execute BrawlStars.setup(token) before access Service!")
        }
        return service!!
    }

}