package io.github.marcusadriano.brawlstars.service.impl

import com.google.gson.Gson
import io.github.marcusadriano.brawlstars.model.BattleLog
import io.github.marcusadriano.brawlstars.model.Error
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result
import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.github.marcusadriano.brawlstars.service.BrawlStarsServiceApi
import retrofit2.Response

internal class BrawlStarsServiceImpl(private val api: BrawlStarsServiceApi) : BrawlStarsService {

    protected fun <T> parseResult(response: Response<T>): Result<T> {
        if (response.isSuccessful) {
            return Result.Success(response.body()!!)
        }

        val errorDetails: Error = Gson().fromJson(response.errorBody()!!.string(), Error::class.java)
        return Result.Error(errorDetails)
    }

    override fun player(playerTag: String): Result<Player> {
        val response = api.player(playerTag).execute()
        return parseResult<Player>(response)
    }

    override fun battleLog(playerTag: String): Result<BattleLog> {
        val response = api.battleLog(playerTag).execute()
        return parseResult<BattleLog>(response)
    }
}