package me.kingOf0.kabilities;

import me.kingOf0.kabilities.base.KSign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class UserListener implements Listener {

    private final KAbilitiesManager manager;

    public UserListener(KAbilitiesManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void join(PlayerJoinEvent event) {
        manager.addPlayer(event.getPlayer().getUniqueId());
        event.getPlayer().getInventory().setHeldItemSlot(0);
    }

    @EventHandler
    public void leave(PlayerQuitEvent event) {
        manager.removePlayer(event.getPlayer().getUniqueId());
    }

     /*
    1 NONE
    2 TIGER,
    3 MONKEY,
    4 DRAGON,
    5 RAT,
    6 BIRD,
    7 SNAKE,
    8 OX,
    9 DOG,
     */
    private final List<KSign> signs = new ArrayList<KSign>() {{
         add(KSign.TIGER);
         add(KSign.MONKEY);
         add(KSign.DRAGON);
         add(KSign.RAT);
         add(KSign.BIRD);
         add(KSign.SNAKE);
         add(KSign.OX);
         add(KSign.DOG);
     }};

    @EventHandler
    public void onSign(PlayerItemHeldEvent event) {
        int newSlot = event.getNewSlot();
        if (newSlot == 0) return;
        manager.addSign(event.getPlayer().getUniqueId(), signs.get(newSlot - 1));

        event.setCancelled(true);
    }

}
