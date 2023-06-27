package rip.shukaaa.testyay.stores;

import org.bukkit.Particle;
import rip.shukaaa.testyay.enums.Setting;

import java.util.HashMap;

public class TrailStore {
    public static Particle particle = Particle.FLAME;
    public static int amount = 1;

    public static HashMap<Setting, Boolean> settings = new HashMap<>();
    static {
        settings.put(Setting.ENABLED, true);
        settings.put(Setting.DISABLE_ON_SNEAK, true);
    }
}
