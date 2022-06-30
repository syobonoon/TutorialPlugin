package net.syobonoon.plugin.tutorialplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

class TutorialScheduler extends BukkitRunnable{
	JavaPlugin plugin;
	private int time;

	public TutorialScheduler(JavaPlugin plugin, int time) {
		this.plugin = plugin;
		this.time = time;
	}

	@Override
	public void run() {

		if (time < 0) {
			cancel();
			return;
		}
		Bukkit.broadcastMessage("残り " + time + "秒");
		time--;
	}
}

