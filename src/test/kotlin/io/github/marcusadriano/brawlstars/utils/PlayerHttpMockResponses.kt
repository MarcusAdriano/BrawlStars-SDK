package io.github.marcusadriano.brawlstars.utils

import com.google.gson.Gson
import io.github.marcusadriano.brawlstars.model.BattleLog
import io.github.marcusadriano.brawlstars.model.Player
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response

object PlayerHttpMockResponses {

    const val PLAYER_RESPONSE_OK: String = "{ \"tag\": \"#V2GP99J8\", \"name\": \"JOSEFA\", \"nameColor\": \"0xffff8afb\", \"icon\": { \"id\": 28000000 }, \"trophies\": 570, \"highestTrophies\": 570, \"expLevel\": 13, \"expPoints\": 1262, \"isQualifiedFromChampionshipChallenge\": false, \"3vs3Victories\": 49, \"soloVictories\": 2, \"duoVictories\": 30, \"bestRoboRumbleTime\": 0, \"bestTimeAsBigBrawler\": 0, \"club\": {}, \"brawlers\": [ { \"id\": 16000000, \"name\": \"SHELLY\", \"power\": 5, \"rank\": 13, \"trophies\": 238, \"highestTrophies\": 238, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000001, \"name\": \"COLT\", \"power\": 4, \"rank\": 7, \"trophies\": 81, \"highestTrophies\": 81, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000002, \"name\": \"BULL\", \"power\": 2, \"rank\": 4, \"trophies\": 38, \"highestTrophies\": 38, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000006, \"name\": \"BARLEY\", \"power\": 4, \"rank\": 4, \"trophies\": 36, \"highestTrophies\": 36, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000007, \"name\": \"JESSIE\", \"power\": 1, \"rank\": 1, \"trophies\": 0, \"highestTrophies\": 0, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000008, \"name\": \"NITA\", \"power\": 5, \"rank\": 5, \"trophies\": 47, \"highestTrophies\": 47, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000013, \"name\": \"POCO\", \"power\": 3, \"rank\": 8, \"trophies\": 112, \"highestTrophies\": 114, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000018, \"name\": \"DARRYL\", \"power\": 1, \"rank\": 1, \"trophies\": 0, \"highestTrophies\": 0, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000024, \"name\": \"ROSA\", \"power\": 1, \"rank\": 1, \"trophies\": 0, \"highestTrophies\": 0, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000025, \"name\": \"CARL\", \"power\": 1, \"rank\": 2, \"trophies\": 10, \"highestTrophies\": 10, \"starPowers\": [], \"gadgets\": [] }, { \"id\": 16000026, \"name\": \"BIBI\", \"power\": 1, \"rank\": 1, \"trophies\": 8, \"highestTrophies\": 8, \"starPowers\": [], \"gadgets\": [] } ] }"
    const val RESPONSE_NOT_FOUND: String = "{\"reason\": \"notFound\" }"
    const val PLAYER_BATTLE_LOG_RESPONSE: String = "{ \"items\": [ { \"battleTime\": \"20200620T005324.000Z\", \"event\": { \"id\": 15000025, \"mode\": \"brawlBall\", \"map\": \"Triple Dribble\" }, \"battle\": { \"mode\": \"brawlBall\", \"type\": \"ranked\", \"result\": \"victory\", \"duration\": 99, \"trophyChange\": 8, \"starPlayer\": { \"tag\": \"#V2GP99J8\", \"name\": \"JOSEFA\", \"brawler\": { \"id\": 16000001, \"name\": \"COLT\", \"power\": 4, \"trophies\": 105 } }, \"teams\": [ [ { \"tag\": \"#2LUJYLCY0\", \"name\": \"nl7\", \"brawler\": { \"id\": 16000002, \"name\": \"BULL\", \"power\": 5, \"trophies\": 105 } }, { \"tag\": \"#2JPJQVQ9L\", \"name\": \"condecats ruger\", \"brawler\": { \"id\": 16000008, \"name\": \"NITA\", \"power\": 5, \"trophies\": 110 } }, { \"tag\": \"#2YYYRGUGY\", \"name\": \"josepAuLo\", \"brawler\": { \"id\": 16000006, \"name\": \"BARLEY\", \"power\": 5, \"trophies\": 120 } } ], [ { \"tag\": \"#V2GP99J8\", \"name\": \"JOSEFA\", \"brawler\": { \"id\": 16000001, \"name\": \"COLT\", \"power\": 4, \"trophies\": 105 } }, { \"tag\": \"#2GCQU29QV\", \"name\": \"tgd_navi\", \"brawler\": { \"id\": 16000024, \"name\": \"ROSA\", \"power\": 4, \"trophies\": 109 } }, { \"tag\": \"#2JLJURL0P\", \"name\": \"LordWolf\", \"brawler\": { \"id\": 16000008, \"name\": \"NITA\", \"power\": 5, \"trophies\": 110 } } ] ] } }, { \"battleTime\": \"20200620T005053.000Z\", \"event\": { \"id\": 15000025, \"mode\": \"brawlBall\", \"map\": \"Triple Dribble\" }, \"battle\": { \"mode\": \"brawlBall\", \"type\": \"ranked\", \"result\": \"victory\", \"duration\": 73, \"trophyChange\": 8, \"starPlayer\": { \"tag\": \"#C9CVR8LL\", \"name\": \"toddyn\", \"brawler\": { \"id\": 16000037, \"name\": \"SPROUT\", \"power\": 1, \"trophies\": 103 } }, \"teams\": [ [ { \"tag\": \"#V2GP99J8\", \"name\": \"JOSEFA\", \"brawler\": { \"id\": 16000001, \"name\": \"COLT\", \"power\": 4, \"trophies\": 97 } }, { \"tag\": \"#C9CVR8LL\", \"name\": \"toddyn\", \"brawler\": { \"id\": 16000037, \"name\": \"SPROUT\", \"power\": 1, \"trophies\": 103 } }, { \"tag\": \"#2YCPJLU9V\", \"name\": \"Guilherme\", \"brawler\": { \"id\": 16000013, \"name\": \"POCO\", \"power\": 3, \"trophies\": 98 } } ], [ { \"tag\": \"#PJ0PUJGG8\", \"name\": \"fernando06\", \"brawler\": { \"id\": 16000010, \"name\": \"EL PRIMO\", \"power\": 2, \"trophies\": 98 } }, { \"tag\": \"#YRV28VQU\", \"name\": \"<c8>Jofre</c>\", \"brawler\": { \"id\": 16000006, \"name\": \"BARLEY\", \"power\": 3, \"trophies\": 106 } }, { \"tag\": \"#9RPJG2ULL\", \"name\": \"ADEXE\", \"brawler\": { \"id\": 16000000, \"name\": \"SHELLY\", \"power\": 3, \"trophies\": 101 } } ] ] } } ], \"paging\": { \"cursors\": {} } }"
    const val RESPONSE_UNAUTHORIZED: String = "{ \"reason\": \"accessDenied\", \"message\": \"Invalid authorization\" }"

    @JvmStatic private fun body(body: String): ResponseBody {
        return ResponseBody.create(MediaType.parse("application/json"), body)
    }

    @JvmStatic fun player(): Response<Player> {
        return Response.success(Gson().fromJson(PLAYER_RESPONSE_OK, Player::class.java))
    }

    @JvmStatic fun <T> notFound(): Response<T> {
        return Response.error(404, body(RESPONSE_NOT_FOUND))
    }

    @JvmStatic fun <T> unauthorized(): Response<T> {
        return Response.error(403, body(RESPONSE_UNAUTHORIZED))
    }

    @JvmStatic fun battleLog(): Response<BattleLog> {
        return Response.success(Gson().fromJson(PLAYER_BATTLE_LOG_RESPONSE, BattleLog::class.java))
    }
}