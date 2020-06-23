package io.github.marcusadriano.brawlstars.service.impl

import com.google.gson.Gson
import io.github.marcusadriano.brawlstars.model.BattleLog
import io.github.marcusadriano.brawlstars.model.Error
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result
import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.github.marcusadriano.brawlstars.service.BrawlStarsServiceApi
import io.github.marcusadriano.brawlstars.utils.PlayerHttpMockResponses
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations
import retrofit2.mock.Calls

internal class BrawlStarsServiceImplTest {

    @Mock
    private lateinit var bsapi: BrawlStarsServiceApi
    private lateinit var service: BrawlStarsService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        this.service = BrawlStarsServiceImpl(bsapi)

        `when`(bsapi.player(anyString())).thenReturn(Calls.response(PlayerHttpMockResponses.player()))
        `when`(bsapi.battleLog(anyString())).thenReturn(Calls.response(PlayerHttpMockResponses.battleLog()))
    }

    @Test
    fun shouldGetPlayerInfos() {
        val result: Result<Player> = service.player("#test")
        assertTrue(result is Result.Success<Player>)
        when(result) {
            is Result.Success<Player> -> {
                val player = result.data
                val expectedPlayer = PlayerHttpMockResponses.player().body()!!

                assertEquals(expectedPlayer.name, player.name)
                assertEquals(expectedPlayer.trophies, player.trophies)
            }
            else -> error("result != player ==> $result")
        }

    }

    @Test
    fun shouldGetErrorNotFound() {
        Mockito.reset(bsapi)
        `when`(bsapi.player(anyString())).thenReturn(Calls.response(PlayerHttpMockResponses.notFound<Player>()))
        val result: Result<Player> = service.player("#test")
        assertTrue(result is Result.Error)
        when (result) {
            is Result.Error -> {
                val error = result.data
                val expectedPlayer = Gson().fromJson(PlayerHttpMockResponses.RESPONSE_NOT_FOUND, Error::class.java)
                assertEquals(expectedPlayer.reason, error.reason)
            }
            else -> error("result != error ==> $result")
        }
    }

    @Test
    fun shouldGetPlayerBattleLog() {
        val result: Result<BattleLog> = service.battleLog("#test")
        assertTrue(result is Result.Success<BattleLog>)
        when(result) {
            is Result.Success<BattleLog> -> {
                val battleLog = result.data
                val expectedPlayer = PlayerHttpMockResponses.battleLog().body()!!

                assertEquals(expectedPlayer.items!!.size, battleLog.items!!.size)
            }
            else -> error("result != player ==> $result")
        }
    }

    @Test
    fun shouldGetErrorNotFoundBattleLog() {
        Mockito.reset(bsapi)
        `when`(bsapi.battleLog(anyString())).thenReturn(Calls.response(PlayerHttpMockResponses.notFound<BattleLog>()))
        val result: Result<Player> = service.player("#test")
        assertTrue(result is Result.Error)
        when (result) {
            is Result.Error -> {
                val error = result.data
                val expectedPlayer = Gson().fromJson(PlayerHttpMockResponses.RESPONSE_NOT_FOUND, Error::class.java)
                assertEquals(expectedPlayer.reason, error.reason)
            }
            else -> error("result != error ==> $result")
        }
    }
}