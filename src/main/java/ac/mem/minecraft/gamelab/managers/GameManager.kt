package ac.mem.minecraft.gamelab.managers

import ac.mem.minecraft.gamelab.Gamelab
import ac.mem.minecraft.gamelab.enums.GameStatus
import ac.mem.minecraft.gamelab.utils.Sidebar
import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scheduler.BukkitTask

class GameManager {
    private val server = Bukkit.getServer()
    private val plugin = Gamelab


    private var status = GameStatus.WAITING

    private var task: BukkitTask? = null

    fun enable(plugin: Gamelab) {
        task = object : BukkitRunnable() {
            override fun run() {
                updateSidebar()
            }
        }.runTaskTimer(plugin, 0, 2)
    }

    fun disable(plugin: Gamelab) {
        task!!.cancel()
    }

    fun updateStatus(status: GameStatus) {
        this.status = status
    }

    fun updateSidebar() {
        server.onlinePlayers.forEach { p: Player ->
            val content = "123\n456\n${p.location.blockX} ${p.location.blockY} ${p.location.blockZ}"
            Sidebar.update(p, "Mem\'s Game Lab", content.split('\n'))
        }
    }
}