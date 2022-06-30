package net.syobonoon.plugin.tutorialplugin;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

class TutorialListener implements Listener {
	Plugin plugin;

	public TutorialListener(Plugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}

	@EventHandler
	public void onDeathEvent(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer(); //①

		p.sendMessage("死んでしまいました..."); //②
		p.setGameMode(GameMode.SPECTATOR); //③
	}

}
