package ac.mem.minecraft.gamelab.listeners

import ac.mem.minecraft.gamelab.Gamelab
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerListener : Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player;
        player.sendMessage("welcome join");

        Gamelab.playerManager.addPlayer(player);
    }
}