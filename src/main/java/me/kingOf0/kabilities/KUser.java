package me.kingOf0.kabilities;

import me.kingOf0.kabilities.base.KNode;
import me.kingOf0.kabilities.base.KSign;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class KUser {

    private final static KAbilities main = KAbilities.getPlugin(KAbilities.class);
    private final static KAbilitiesManager manager = main.getManager();

    private final UUID uuid;
    private final List<KSign> signs = new ArrayList<>();
    private Integer runnableId;

    public KUser(UUID uuid) {
        this.uuid = uuid;
    }

    public void addSign(KSign sign) {
        signs.add(sign);

        if (runnableId != null) main.getServer().getScheduler().cancelTask(runnableId);
        runnableId = new BukkitRunnable() {
            @Override
            public void run() {
                callAbility();
                signs.clear();
            }
        }.runTaskLaterAsynchronously(main, 20).getTaskId();
    }

    private void callAbility() {
        Iterator<KSign> iterator = signs.iterator();
        KNode lastNode = null;
        if (iterator.hasNext()) lastNode = manager.getNode(iterator.next());

        while (iterator.hasNext()) {
            KSign sign = iterator.next();
            lastNode = lastNode.getNode(sign);
            if (lastNode == null) break;
            if (!iterator.hasNext()) {
                //its last sign
                if (lastNode != null) lastNode.castAbility(uuid);
            }
        }

    }

    public void destroy() {
        if (runnableId != null) main.getServer().getScheduler().cancelTask(runnableId);
    }
}
