package io.github.marcusadriano.brawlstars.utils

import com.google.gson.Gson
import io.github.marcusadriano.brawlstars.model.Player
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response

object HttpMockResponses {

    const val PLAYER_RESPONSE_OK: String = "{ \"tag\": \"#V2GP99J8\", \"name\": \"JOSEFA\", \"nameColor\": \"0xffff8afb\", \"icon\": { \"id\": 28000000 }, \"trophies\": 570, \"highestTrophies\": 570, \"expLevel\": 13, \"expPoints\": 1262, \"isQualifiedFromChampionshipChallenge\": false, \"3vs3Victories\": 49, \"soloVictories\": 2, \"duoVictories\": 30, \"bestRoboRumbleTime\": 0, \"bestTimeAsBigBrawler\": 0, \"club\": {}, \"brawlers\": [ { \"id\": 16000000, \"name\": \"SHELLY\", \"power\": 5, \"rank\": 13, \"trophies\": 238, \"highestTrophies\": 238, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000001, \"name\": \"COLT\", \"power\": 4, \"rank\": 7, \"trophies\": 81, \"highestTrophies\": 81, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000002, \"name\": \"BULL\", \"power\": 2, \"rank\": 4, \"trophies\": 38, \"highestTrophies\": 38, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000006, \"name\": \"BARLEY\", \"power\": 4, \"rank\": 4, \"trophies\": 36, \"highestTrophies\": 36, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000007, \"name\": \"JESSIE\", \"power\": 1, \"rank\": 1, \"trophies\": 0, \"highestTrophies\": 0, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000008, \"name\": \"NITA\", \"power\": 5, \"rank\": 5, \"trophies\": 47, \"highestTrophies\": 47, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000013, \"name\": \"POCO\", \"power\": 3, \"rank\": 8, \"trophies\": 112, \"highestTrophies\": 114, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000018, \"name\": \"DARRYL\", \"power\": 1, \"rank\": 1, \"trophies\": 0, \"highestTrophies\": 0, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000024, \"name\": \"ROSA\", \"power\": 1, \"rank\": 1, \"trophies\": 0, \"highestTrophies\": 0, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000025, \"name\": \"CARL\", \"power\": 1, \"rank\": 2, \"trophies\": 10, \"highestTrophies\": 10, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000026, \"name\": \"BIBI\", \"power\": 1, \"rank\": 1, \"trophies\": 8, \"highestTrophies\": 8, \"starPowers\": [], \"gadgets\": [] } ] }"
    const val RESPONSE_NOT_FOUND: String = "{\"reason\": \"notFound\" }"
    const val RESPONSE_UNAUTHORIZED: String = "{ \"reason\": \"accessDenied\", \"message\": \"Invalid authorization\" }"

    @JvmStatic private fun body(body: String): ResponseBody {
        return ResponseBody.create(MediaType.parse("application/json"), body)
    }

    @JvmStatic fun player(): Response<Player> {
        return Response.success(Gson().fromJson(PLAYER_RESPONSE_OK, Player::class.java))
    }

    @JvmStatic fun notFound(): Response<Player> {
        return Response.error(404, body(RESPONSE_NOT_FOUND))
    }

    @JvmStatic fun unauthorized(): Response<String> {
        return Response.error(403, body(RESPONSE_UNAUTHORIZED))
    }
}