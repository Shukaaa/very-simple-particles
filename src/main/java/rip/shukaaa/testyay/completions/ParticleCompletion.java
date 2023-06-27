package rip.shukaaa.testyay.completions;

import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ParticleCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();

            // Add all particles to the list
            for (Particle particle : Particle.values()) {
                arguments.add(particle.name());
            }

            return arguments;

        } else if (args.length > 1) {
            List<String> arguments = new ArrayList<>();
            return arguments;
        }

        return null;
    }
}
