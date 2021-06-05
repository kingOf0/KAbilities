package me.kingOf0.kabilities.base;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public abstract class KAbility {

   public void cast(UUID uuid) {
      Player player = Bukkit.getPlayer(uuid);
      if (player != null) cast(player);
   }

   public abstract void cast(Player player);
}
