package ac.mem.minecraft.gamelab.utils

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Criteria
import org.bukkit.scoreboard.DisplaySlot

object Sidebar {
    private val server = Bukkit.getServer()
    private val manager =  server.scoreboardManager

    fun update(player: Player, title: String, content: List<String>) {
        val scoreboard = manager.newScoreboard
        val name = "test"

        val objective = scoreboard.registerNewObjective(name, Criteria.DUMMY, title)
        objective.displaySlot = DisplaySlot.SIDEBAR

        for (i in content.indices) {
            val score = objective.getScore(content[i])
            score.score = content.size - i
        }

        player.scoreboard = scoreboard
    }
}