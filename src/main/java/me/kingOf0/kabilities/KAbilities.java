package me.kingOf0.kabilities;

import me.kingOf0.kabilities.base.KNode;
import me.kingOf0.kabilities.base.KSign;
import me.kingOf0.kabilities.base.ability.SpawnIronGolem;
import me.kingOf0.kabilities.base.ability.SpawnSpider;
import me.kingOf0.kabilities.base.ability.ThrowArrow;
import org.bukkit.plugin.java.JavaPlugin;

public class KAbilities extends JavaPlugin {

    private KAbilitiesManager manager;

    @Override
    public void onEnable() {

        manager = new KAbilitiesManager();

        // tiger -> dragon -> monkey
        KNode spawnIronGolem = new KNode(new SpawnIronGolem());

        // tiger -> dragon -> OX
        KNode throwArrow = new KNode(new ThrowArrow());

        // tiger -> BIRD
        KNode spider = new KNode(new SpawnSpider());


        KNode dragon = new KNode();
        dragon.addNode(KSign.MONKEY, spawnIronGolem);
        dragon.addNode(KSign.OX, throwArrow);

        KNode tiger = new KNode();
        tiger.addNode(KSign.DRAGON, dragon);
        tiger.addNode(KSign.DRAGON, spider);

        manager.addNode(KSign.TIGER, tiger);


        getServer().getPluginManager().registerEvents(new UserListener(manager), this);
    }

    public KAbilitiesManager getManager() {
        return manager;
    }
}
