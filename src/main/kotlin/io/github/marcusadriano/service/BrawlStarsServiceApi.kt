package io.github.marcusadriano.service

import io.github.marcusadriano.model.BattleLog
import io.github.marcusadriano.model.Player
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface BrawlStarsServiceApi {

    @GET("players/{playerTag}")
    fun player(@Path("playerTag") playerTag: String): Call<Player>

    @GET("players/{playerTag}/battlelog")
    fun battleLog(@Path("playerTag") playerTag: String): Call<BattleLog>

}