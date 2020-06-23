package io.github.marcusadriano.brawlstars

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BrawlStarsTest {

    @Test
    fun `should create BsService Instance`() {
        BrawlStars.setup("any")
        val bs = BrawlStars.service()
        assertNotNull(bs)
    }

    @Test
    fun `should throw RuntimeException`() {
        assertThrows<RuntimeException> {
            BrawlStars.service()
        }
    }
}