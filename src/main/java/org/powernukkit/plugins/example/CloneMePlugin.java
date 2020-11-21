package org.powernukkit.plugins.example;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.PluginCommand;
import cn.nukkit.plugin.PluginBase;

public class CloneMePlugin extends PluginBase {
    @Override
    public void onEnable() {
        getLogger().info("Hello world! :D");
        if (System.getProperty("os.name").startsWith("Windows")) {
            getLogger().warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            getLogger().warning("!!! ATTENTION WINDOWS USER !!!");
            getLogger().warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            getLogger().warning("To connect to the server in localhost you must allow the game to access localhost:");
            getLogger().warning("1. Open PowerShell as admin");
            getLogger().warning("2. Run this command: CheckNetIsolation LoopbackExempt -a -n=\"Microsoft.MinecraftUWP_8wekyb3d8bbwe\"");
            getLogger().warning("3. Restart your computer (if needed, try to restart your game first)");
            getLogger().warning("This issue occurs due to loopback restrictions on Windows 10 UWP apps");
        }
        
        getLogger().info("TIP: Make sure your break points are set to pause ONLY THE THREAD and NOT ALL THREADS!");
        getLogger().info("https://imgur.com/ygwen76");
        getLogger().info("If you do this, you won't get disconnected when you hit a break point");

        getLogger().info("TIP: If you are using IntelliJ, use Ctrl+F9 (Build Project) to apply non-structural java changes without restart");
        
        // TODO: Make it easier
        // This make the command be executed in a separated class, you need to choose if you want
        // it being executed there or in the onCommand bellow, you can't use both
        // Simple commands are fine in onCommand but complex command might be more organized
        // in their own classes. Also make sure you register this command in plugin.yml
        ((PluginCommand<?>) getCommand("cloneme")).setExecutor(new CloneCommand());
        
        // You must register your listeners to capture events
        // You can make this class implement the Listener itself and invoke registerEvents(this, this)
        // But again, if the listener gets too complicated it might be better to group them in different classes
        getServer().getPluginManager().registerEvents(new CloneListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye world :(");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // You can also override this command instead of setting an executor in onEnable if you prefer
        return false;
    }
}
