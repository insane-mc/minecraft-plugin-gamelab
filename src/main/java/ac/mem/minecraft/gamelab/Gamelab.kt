package ac.mem.minecraft.gamelab

import ac.mem.minecraft.gamelab.listeners.PlayerListener
import ac.mem.minecraft.gamelab.managers.GameManager
import ac.mem.minecraft.gamelab.managers.PlayerManager
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class Gamelab : JavaPlugin() {

    override fun onEnable() {
        instance = this
        gameManager.enable(this)
        playerManager.enable(this)

        Bukkit.getPluginManager().registerEvents(PlayerListener(), this)

        log("plugin enabled!")
    }

    override fun onDisable() {
        gameManager.disable(this)
        playerManager.disable(this)

        println("plugin disabled!")
    }


    companion object {
        var instance: Gamelab? = null
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