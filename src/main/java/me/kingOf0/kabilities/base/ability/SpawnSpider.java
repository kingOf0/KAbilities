package me.kingOf0.kabilities.base.ability;

import me.kingOf0.kabilities.base.KAbility;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnSpider extends KAbility {

    @Override
    public void cast(Player player) {
        player.getWorld().spawnEntity(player.getLocation(), EntityType.SPIDER);
    }
}
