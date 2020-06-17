package io.github.marcusadriano.service

import io.github.marcusadriano.model.BattleLog
import io.github.marcusadriano.model.Player
import io.github.marcusadriano.model.Result

interface BrawlStarsService {

    fun player(playerTag: String): Result<Player>
    fun battleLog(playerTag: String): Result<BattleLog>

}