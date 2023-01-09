package ac.mem.minecraft.gamelab

import org.bukkit.plugin.java.JavaPlugin

class Gamelab : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerJoinListener(), this)

        log("plugin enabled!")
    }

    override fun onDisable() {
        println("plugin disabled!")
    }

}