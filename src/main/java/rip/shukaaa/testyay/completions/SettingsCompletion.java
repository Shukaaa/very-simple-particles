package rip.shukaaa.testyay.completions;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import rip.shukaaa.testyay.enums.Setting;
import rip.shukaaa.testyay.stores.TrailStore;

import java.util.ArrayList;
import java.util.List;

public class SettingsCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();

            // Add all particles to the list
            for (Setting setting : Setting.values()) {
                arguments.add(setting.name());
            }

            return arguments;

        } else if (args.length > 1) {
            List<String> arguments = new ArrayList<>();
            return arguments;
        }

        return null;
    }
}
