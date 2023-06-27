package rip.shukaaa.testyay;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import rip.shukaaa.testyay.completions.AmountCompletion;
import rip.shukaaa.testyay.completions.ParticleCompletion;
import rip.shukaaa.testyay.completions.SettingsCompletion;
import rip.shukaaa.testyay.enums.Amount;
import rip.shukaaa.testyay.enums.Setting;
import rip.shukaaa.testyay.handler.CommandHandler;
import rip.shukaaa.testyay.listeners.PlayerMoveListener;
import rip.shukaaa.testyay.stores.TrailStore;

import java.util.Objects;

public final class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin started!");

        Objects.requireNonNull(getCommand("changeParticle")).setTabCompleter(new ParticleCompletion());
        Objects.requireNonNull(getCommand("changeAmount")).setTabCompleter(new AmountCompletion());
        Objects.requireNonNull(getCommand("changeSettings")).setTabCompleter(new SettingsCompletion());

        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return CommandHandler.handleCommand(sender, command, args);
    }
}
