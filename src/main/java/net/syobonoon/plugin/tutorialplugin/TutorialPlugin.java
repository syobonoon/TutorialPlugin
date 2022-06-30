//package my.test.plugin.tutorialplugin;
//
//import org.bukkit.plugin.java.JavaPlugin;
//
//public class TutorialPlugin extends JavaPlugin {
//
//    @Override
//    public void onEnable() {
//    	new TutorialListener(this);
//        getCommand("dainai").setExecutor(new TutorialCommand(this));
//        getCommand("countdown").setExecutor(new TutorialCommand(this));
//        getLogger().info("test enable");
//    }
//
//    @Override
//    public void onDisable() {
//        getLogger().info("test disable");
//    }
//}

package net.syobonoon.plugin.tutorialplugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TutorialPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		new TutorialListener(this);
		getLogger().info("test enable");
	}

	@Override
	public void onDisable() {
		getLogger().info("test disable");
	}
}