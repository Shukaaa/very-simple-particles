package rip.shukaaa.testyay.completions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import rip.shukaaa.testyay.enums.Amount;

import java.util.ArrayList;
import java.util.List;

public class AmountCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();

            // Add all amounts to the list
            for (Amount amount : Amount.values()) {
                arguments.add(amount.name());
            }

            return arguments;

        } else if (args.length > 1) {
            List<String> arguments = new ArrayList<>();
            return arguments;
        }

        return null;
    }
}
