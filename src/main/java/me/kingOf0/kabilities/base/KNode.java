package me.kingOf0.kabilities.base;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KNode {

    private final Map<KSign, KNode> nodes = new HashMap<>();

    private final KAbility ability;

    public KNode(KAbility ability) {
        this.ability = ability;
    }

    public KNode() {
        this.ability = null;
    }


    public KNode getNode(KSign sign) {
        return nodes.getOrDefault(sign, null);
    }

    public KAbility getAbility() {
        return ability;
    }

    public void castAbility(UUID uuid) {
        if (ability != null) ability.cast(uuid);
    }

    public void addNode(KSign sign, KNode node) {
        nodes.put(sign, node);
    }
}
