package ac.mem.minecraft.gamelab

import ac.mem.minecraft.gamelab.listeners.PlayerJoinListener
import ac.mem.minecraft.gamelab.managers.GameManager
import ac.mem.minecraft.gamelab.managers.PlayerManager
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Gamelab : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerJoinListener(), this)

        log("plugin enabled!")
    }

    override fun onDisable() {
        println("plugin disabled!")
    }


    companion object {
        val gameManager: GameManager = GameManager()
        val playerManager: PlayerManager = PlayerManager()


        private val server = Bukkit.getServer()

        fun log(vararg args: String) {
            val message: String = if (args.isEmpty()) {
                ""
            } else if (args.size == 1) {
                args[0]
            } else {
                val builder = StringBuilder()
                for (i in args.indices) {
                    if (i > 0) {
                        builder.append(' ')
                    }
                    builder.append(args[0])
                }
                builder.toString()
            }
            println(message)
            server.onlinePlayers.forEach {
                it.sendMessage(ChatColor.GRAY.toString() + "[MemGameLab] " + ChatColor.RESET + message)
            }
        }
    }
}