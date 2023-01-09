package ac.mem.minecraft.gamelab.managers

import ac.mem.minecraft.gamelab.Gamelab
import ac.mem.minecraft.gamelab.enums.GameStatus
import ac.mem.minecraft.gamelab.utils.Sidebar
import org.bukkit.Bukkit
import org.bukkit.Server
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

class GameManager {
    private val server = Bukkit.getServer()
    private val plugin = Gamelab


    private var status = GameStatus.WAITING

    init {
//        val task = object : BukkitRunnable() {
//            override fun run() {
//                updateSidebar()
//            }
//        }.runTaskTimer(plugin, 5, 10000);
    }

    fun updateStatus(status: GameStatus) {
        this.status = status
    }

    fun updateSidebar() {
        server.onlinePlayers.forEach { p: Player ->
            Sidebar.update(p, "Mem\'s Game Lab", arrayOf("123", "456"))
        }
    }
}