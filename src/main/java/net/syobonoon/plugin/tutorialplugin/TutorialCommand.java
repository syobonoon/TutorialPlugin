package net.syobonoon.plugin.tutorialplugin;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TutorialCommand implements TabExecutor {
	JavaPlugin plugin;

	public TutorialCommand(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		boolean isSuccess = false;
		if (command.getName().equalsIgnoreCase("countdown")) isSuccess = countdown(sender, args);
		if (command.getName().equalsIgnoreCase("dainai")) isSuccess = dainai(sender, args); //①
		return isSuccess;
	}

	@Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1) return null;
		return null;
    }

	private boolean countdown(CommandSender sender, String[] args) {

		if (args.length != 1) {
	        sender.sendMessage(ChatColor.RED + "There are too many parameters.");
	        return false;
	    }

		int time;
		try {
			time = Integer.valueOf(args[0]);
		} catch(NumberFormatException e) {
			sender.sendMessage(ChatColor.RED + "This is not a number.");
			return false;
		}

		new TutorialScheduler(plugin, time).runTaskTimer(this.plugin, 0L, 20L);
	    return true;
	}

	private boolean dainai(CommandSender sender, String[] args) {
		//①
		Player target = (Player) sender;
		if (!(sender instanceof Player)) return false;

		//②
		if (args.length > 1) {
	        sender.sendMessage(ChatColor.RED + "There are too many parameters.");
	        return false;
	    }

		//③
		if (args.length == 1) target = Bukkit.getPlayerExact(args[0]);
	    if (target == null) {
	        sender.sendMessage(ChatColor.RED + args[0] + "is not on the server.");
	        return false;
	    }

	    //④
	    Location t_loc = target.getLocation();
	    target.getWorld().strikeLightningEffect(t_loc);
	    target.getWorld().createExplosion(t_loc, 0);
	    target.getWorld().spawnParticle(Particle.CLOUD, t_loc, 500, 10, 10, 10, 0.1);
	    target.setHealth(0.0D);
	    return true;
    }
}
