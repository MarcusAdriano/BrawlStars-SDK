package examples

import io.github.marcusadriano.brawlstars.BrawlStars
import io.github.marcusadriano.brawlstars.model.Battle
import io.github.marcusadriano.brawlstars.model.BattleLog
import io.github.marcusadriano.brawlstars.model.Player
import io.github.marcusadriano.brawlstars.model.Result

fun countBattleResult(battle: Battle, counter: Int): Int {
    var value = counter
    if (battle.type != "ranked") {
        return counter
    }
    if (battle.result != null) {
        when (battle.result) {
            "victory" -> value++
        }
    }

    if (battle.rank != null) {
        when (battle.rank) {
            1, 2 -> value++
        }
    }

    return value
}

fun printResult(result: Result<BattleLog>) {
    when(result) {
        is Result.Success -> {
            val battleLog = result.data
            var totalTrophies = 0
            var totalVictories = 0
            val totalBattles = battleLog.items!!.size

            battleLog.items.forEach {
                val battle: Battle = it.battle as Battle
                if (battle.trophyChange != null) {
                    totalTrophies += battle.trophyChange
                }
                totalVictories = countBattleResult(battle, totalVictories)
            }
            val percent = totalVictories.toDouble()/totalBattles * 100
            println("You won $percent% of $totalBattles battles. Sum total of $totalTrophies trophies")
        }
        is Result.Error -> {
            println("Error ==> ${result.data.reason}")
        }
    }
}

fun main(args: Array<String>) {
    val token = args[0]
    BrawlStars.setup(token)
    val service = BrawlStars.service()
    val result: Result<BattleLog> = service.battleLog("#9UV9UG9J")
    printResult(result)
}

