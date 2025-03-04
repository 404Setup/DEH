package one.tranic.deh;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener {

    private static Main instance;
    private Metrics metrics;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Config.reload();
        metrics = new Metrics(this, 24983);
        this.getServer().getPluginManager().registerEvents(new Event(), this);
        Objects.requireNonNull(this.getServer().getPluginCommand("deh-reload")).setExecutor(this);
        Objects.requireNonNull(this.getServer().getPluginCommand("deh-reload")).setTabCompleter(this);
    }

    @Override
    public void onDisable() {
        if (metrics != null) {
            metrics.shutdown();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("tranic.deh")) {
            sender.sendMessage(ChatColor.RED + "Not enough permission to use this command !");
            return true;
        }
        Config.reload();
        sender.sendMessage(ChatColor.GREEN + "Config reloaded !");
        return true;
    }


}