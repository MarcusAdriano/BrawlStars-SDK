package io.github.marcusadriano.brawlstars.service.impl

import com.google.gson.Gson
import io.github.marcusadriano.brawlstars.BrawlStarsAuthInterceptor
import io.github.marcusadriano.brawlstars.BrawlStarsToken
import io.github.marcusadriano.brawlstars.model.BattleLog
import io.github.marcusadriano.brawlstars.model.Error
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result
import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.github.marcusadriano.brawlstars.service.BrawlStarsServiceApi
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BrawlStarsServiceImpl(val token: BrawlStarsToken) : BrawlStarsService {

    private val retrofit: Retrofit
    private val api: BrawlStarsServiceApi

    init {
        val tokenInterceptor = BrawlStarsAuthInterceptor(token)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.brawlstars.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(BrawlStarsServiceApi::class.java)
    }

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