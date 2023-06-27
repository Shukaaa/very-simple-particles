package rip.shukaaa.testyay.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import rip.shukaaa.testyay.enums.Setting;
import rip.shukaaa.testyay.stores.TrailStore;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (
            (!TrailStore.settings.get(Setting.ENABLED) || event.getPlayer().isInvisible()) ||
            (TrailStore.settings.get(Setting.DISABLE_ON_SNEAK) && player.isSneaking())
        ) { return; }

        player.getWorld().spawnParticle(TrailStore.particle, player.getLocation(), TrailStore.amount, 0, 0, 0, 0.05);
    }

}
