package rip.shukaaa.testyay.handler;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import rip.shukaaa.testyay.enums.Amount;
import rip.shukaaa.testyay.enums.Setting;
import rip.shukaaa.testyay.stores.TrailStore;

public class CommandHandler {
    public static boolean handleCommand(CommandSender sender, Command command, String[] args) {
        if (command.getName().equalsIgnoreCase("changeParticle")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Please specify a particle!");
                return true;
            }

            String particle = args[0];

            try {
                TrailStore.particle = Particle.valueOf(particle);
                sender.sendMessage(ChatColor.GREEN + "Particle changed to " + particle + "!");
            } catch (IllegalArgumentException e) {
                sender.sendMessage(ChatColor.RED + "Invalid particle!");
            }
        }

        if (command.getName().equalsIgnoreCase("changeAmount")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Please specify an amount!");
                return true;
            }

            String amount = args[0];

            try {
                TrailStore.amount = Amount.valueOf(amount).getAmount();
                sender.sendMessage(ChatColor.GREEN + "Amount changed to " + amount + "!");
            } catch (NumberFormatException e) {
                sender.sendMessage(ChatColor.RED + "Invalid amount!");
            }
        }

        if (command.getName().equalsIgnoreCase("changeSettings")) {
            if (args.length != 2) {
                sender.sendMessage(ChatColor.RED + "Please specify a setting and a certain value!");
                return true;
            }

            String setting = args[0];
            boolean value;

            if (args[1].equalsIgnoreCase("true") || args[1].equalsIgnoreCase("false")) {
                value = Boolean.parseBoolean(args[1]);
            } else {
                sender.sendMessage(ChatColor.RED + "Please specify if the setting should be true or false!");
                return true;
            }

            try {
                TrailStore.settings.replace(Setting.valueOf(setting), value);
                sender.sendMessage(ChatColor.GREEN + "Set setting " + setting + " to " + value + "!");
            } catch (IllegalArgumentException e) {
                sender.sendMessage(ChatColor.RED + "Invalid setting!");
            }
        }

        return true;
    }
}
