package me.kingOf0.kabilities.base.ability;

import me.kingOf0.kabilities.base.KAbility;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ThrowArrow extends KAbility {

    @Override
    public void cast(Player player) {
        Arrow arrow = (Arrow) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARROW);
        //not sure about this, didn't checked docs or something just writed. Dont forget that this is a example
        arrow.setVelocity(player.getLocation().getDirection());
    }
}
