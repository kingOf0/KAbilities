package me.kingOf0.kabilities;

import me.kingOf0.kabilities.base.KNode;
import me.kingOf0.kabilities.base.KSign;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KAbilitiesManager {

    public final Map<UUID, KUser> users = new HashMap<>();
    public final Map<KSign, KNode> nodes = new HashMap<>();

    public KNode getNode(KSign sign) {
        return nodes.getOrDefault(sign, null);
    }

    public void addNode(KSign sign, KNode node) {
        nodes.put(sign, node);
    }

    public void addPlayer(UUID uuid) {
        users.put(uuid, new KUser(uuid));
    }

    public void removePlayer(UUID uuid) {
        users.get(uuid).destroy();
        users.remove(uuid);
    }

    public void addSign(UUID uuid, KSign sign) {
        users.get(uuid).addSign(sign);
    }
}
