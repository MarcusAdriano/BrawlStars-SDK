package io.github.marcusadriano.brawlstars

import io.github.marcusadriano.brawlstars.model.BrawlStarsToken
import io.github.marcusadriano.brawlstars.service.BrawlStarsService
import io.github.marcusadriano.brawlstars.service.BrawlStarsServiceApi
import io.github.marcusadriano.brawlstars.service.impl.BrawlStarsServiceImpl
import io.github.marcusadriano.brawlstars.model.BrawlStarsAuthInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.RuntimeException

object BrawlStars {

    private var service: BrawlStarsService? = null

    @JvmStatic fun setup(token: String) {
        val bsToken = BrawlStarsToken(token)

        val tokenInterceptor =
            BrawlStarsAuthInterceptor(bsToken)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.brawlstars.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(BrawlStarsServiceApi::class.java)
        service = BrawlStarsServiceImpl(api)
    }

    @JvmStatic fun service(): BrawlStarsService {
        if (service == null) {
            throw RuntimeException("Execute BrawlStars.setup(token) before access Service!")
        }
        return service!!
    }

}