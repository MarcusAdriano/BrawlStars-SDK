package io.github.marcusadriano.brawlstars.service

import io.github.marcusadriano.brawlstars.model.BattleLog
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result

interface BrawlStarsService {

    fun player(playerTag: String): Result<Player>
    fun battleLog(playerTag: String): Result<BattleLog>

}