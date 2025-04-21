package com.mills.enchantShop;

import org.bukkit.enchantments.Enchantment;

import java.util.HashMap;
import java.util.Map;

public class EnchantData {

    public static final Map<Enchantment, Integer> maxLevels = new HashMap<>();
    public static final Map<Enchantment, Map<Integer, Integer>> levelCosts = new HashMap<>();

    static {
        // Sharpness
        maxLevels.put(Enchantment.SHARPNESS, 5);
        Map<Integer, Integer> sharpnessCosts = new HashMap<>();
        sharpnessCosts.put(1, 15000);
        sharpnessCosts.put(2, 20000);
        sharpnessCosts.put(3, 25000);
        sharpnessCosts.put(4, 30000);
        sharpnessCosts.put(5, 40000);
        levelCosts.put(Enchantment.SHARPNESS, sharpnessCosts);

        // Protection
        maxLevels.put(Enchantment.PROTECTION, 4);
        Map<Integer, Integer> protCosts = new HashMap<>();
        protCosts.put(1, 8000);
        protCosts.put(2, 12000);
        protCosts.put(3, 20000);
        protCosts.put(4, 25000);
        levelCosts.put(Enchantment.PROTECTION, protCosts);

        // Unbreaking
        maxLevels.put(Enchantment.UNBREAKING, 3);
        Map<Integer, Integer> unbreakingCosts = new HashMap<>();
        unbreakingCosts.put(1, 8000);
        unbreakingCosts.put(2, 12000);
        unbreakingCosts.put(3, 16000);
        levelCosts.put(Enchantment.UNBREAKING, unbreakingCosts);

        // Fire Protection
        maxLevels.put(Enchantment.FIRE_PROTECTION, 4);
        Map<Integer, Integer> fireProt = new HashMap<>();
        fireProt.put(1, 5000);
        fireProt.put(2, 8000);
        fireProt.put(3, 12000);
        fireProt.put(4, 15000);
        levelCosts.put(Enchantment.FIRE_PROTECTION, fireProt);

        // Blast Protection
        maxLevels.put(Enchantment.BLAST_PROTECTION, 4);
        Map<Integer, Integer> blastProt = new HashMap<>();
        blastProt.put(1, 5000);
        blastProt.put(2, 8000);
        blastProt.put(3, 12000);
        blastProt.put(4, 15000);
        levelCosts.put(Enchantment.BLAST_PROTECTION, blastProt);

        // Projectile Protection
        maxLevels.put(Enchantment.PROJECTILE_PROTECTION, 4);
        Map<Integer, Integer> projProt = new HashMap<>();
        projProt.put(1, 5000);
        projProt.put(2, 8000);
        projProt.put(3, 12000);
        projProt.put(4, 15000);
        levelCosts.put(Enchantment.PROJECTILE_PROTECTION, projProt);

        // Respiration
        maxLevels.put(Enchantment.RESPIRATION, 3);
        Map<Integer, Integer> respiration = new HashMap<>();
        respiration.put(1, 6000);
        respiration.put(2, 10000);
        respiration.put(3, 15000);
        levelCosts.put(Enchantment.RESPIRATION, respiration);

        // Aqua Affinity
        maxLevels.put(Enchantment.AQUA_AFFINITY, 1);
        Map<Integer, Integer> aqua = new HashMap<>();
        aqua.put(1, 8000);
        levelCosts.put(Enchantment.AQUA_AFFINITY, aqua);

        // Thorns
        maxLevels.put(Enchantment.THORNS, 3);
        Map<Integer, Integer> thorns = new HashMap<>();
        thorns.put(1, 10000);
        thorns.put(2, 15000);
        thorns.put(3, 20000);
        levelCosts.put(Enchantment.THORNS, thorns);

        // Mending
        maxLevels.put(Enchantment.MENDING, 1);
        Map<Integer, Integer> mending = new HashMap<>();
        mending.put(1, 75000);
        levelCosts.put(Enchantment.MENDING, mending);

        // Smite
        maxLevels.put(Enchantment.SMITE, 5);
        Map<Integer, Integer> smite = new HashMap<>();
        smite.put(1, 10000);
        smite.put(2, 15000);
        smite.put(3, 20000);
        smite.put(4, 25000);
        smite.put(5, 30000);
        levelCosts.put(Enchantment.SMITE, smite);

        // Bane of Arthropods
        maxLevels.put(Enchantment.BANE_OF_ARTHROPODS, 5);
        Map<Integer, Integer> arthro = new HashMap<>();
        arthro.put(1, 5000);
        arthro.put(2, 8000);
        arthro.put(3, 10000);
        arthro.put(4, 12000);
        arthro.put(5, 15000);
        levelCosts.put(Enchantment.BANE_OF_ARTHROPODS, arthro);

        // Knockback
        maxLevels.put(Enchantment.KNOCKBACK, 2);
        Map<Integer, Integer> knockback = new HashMap<>();
        knockback.put(1, 8000);
        knockback.put(2, 12000);
        levelCosts.put(Enchantment.KNOCKBACK, knockback);

        // Fire Aspect
        maxLevels.put(Enchantment.FIRE_ASPECT, 2);
        Map<Integer, Integer> fireAspect = new HashMap<>();
        fireAspect.put(1, 10000);
        fireAspect.put(2, 15000);
        levelCosts.put(Enchantment.FIRE_ASPECT, fireAspect);

        // Looting
        maxLevels.put(Enchantment.LOOTING, 3);
        Map<Integer, Integer> looting = new HashMap<>();
        looting.put(1, 50000);
        looting.put(2, 75000);
        looting.put(3, 100000);
        levelCosts.put(Enchantment.LOOTING, looting);

        // Sweeping Edge
        maxLevels.put(Enchantment.SWEEPING_EDGE, 3);
        Map<Integer, Integer> sweep = new HashMap<>();
        sweep.put(1, 20000);
        sweep.put(2, 35000);
        sweep.put(3, 60000);
        levelCosts.put(Enchantment.SWEEPING_EDGE, sweep);

        // Efficiency
        maxLevels.put(Enchantment.EFFICIENCY, 5);
        Map<Integer, Integer> eff = new HashMap<>();
        eff.put(1, 5000);
        eff.put(2, 7500);
        eff.put(3, 10000);
        eff.put(4, 12500);
        eff.put(5, 15000);
        levelCosts.put(Enchantment.EFFICIENCY, eff);

        // Silk Touch
        maxLevels.put(Enchantment.SILK_TOUCH, 1);
        Map<Integer, Integer> silk = new HashMap<>();
        silk.put(1, 25000);
        levelCosts.put(Enchantment.SILK_TOUCH, silk);

        // Fortune
        maxLevels.put(Enchantment.FORTUNE, 3);
        Map<Integer, Integer> fortune = new HashMap<>();
        fortune.put(1, 12000);
        fortune.put(2, 18000);
        fortune.put(3, 36000);
        levelCosts.put(Enchantment.FORTUNE, fortune);

        // Power
        maxLevels.put(Enchantment.POWER, 5);
        Map<Integer, Integer> power = new HashMap<>();
        power.put(1, 10000);
        power.put(2, 15000);
        power.put(3, 20000);
        power.put(4, 25000);
        power.put(5, 30000);
        levelCosts.put(Enchantment.POWER, power);

        // Punch
        maxLevels.put(Enchantment.PUNCH, 2);
        Map<Integer, Integer> punch = new HashMap<>();
        punch.put(1, 8000);
        punch.put(2, 12000);
        levelCosts.put(Enchantment.PUNCH, punch);

        // Flame
        maxLevels.put(Enchantment.FLAME, 1);
        Map<Integer, Integer> flame = new HashMap<>();
        flame.put(1, 10000);
        levelCosts.put(Enchantment.FLAME, flame);

        // Infinity
        maxLevels.put(Enchantment.INFINITY, 1);
        Map<Integer, Integer> infinity = new HashMap<>();
        infinity.put(1, 25000);
        levelCosts.put(Enchantment.INFINITY, infinity);

        // Quick Charge
        maxLevels.put(Enchantment.QUICK_CHARGE, 3);
        Map<Integer, Integer> quick = new HashMap<>();
        quick.put(1, 8000);
        quick.put(2, 12000);
        quick.put(3, 16000);
        levelCosts.put(Enchantment.QUICK_CHARGE, quick);

        // Multishot
        maxLevels.put(Enchantment.MULTISHOT, 1);
        Map<Integer, Integer> multi = new HashMap<>();
        multi.put(1, 15000);
        levelCosts.put(Enchantment.MULTISHOT, multi);

        // Piercing
        maxLevels.put(Enchantment.PIERCING, 4);
        Map<Integer, Integer> pierce = new HashMap<>();
        pierce.put(1, 6000);
        pierce.put(2, 10000);
        pierce.put(3, 15000);
        pierce.put(4, 20000);
        levelCosts.put(Enchantment.PIERCING, pierce);

        // Luck of the Sea
        maxLevels.put(Enchantment.LUCK_OF_THE_SEA, 3);
        Map<Integer, Integer> luck = new HashMap<>();
        luck.put(1, 20000);
        luck.put(2, 35000);
        luck.put(3, 50000);
        levelCosts.put(Enchantment.LUCK_OF_THE_SEA, luck);

        // Lure
        maxLevels.put(Enchantment.LURE, 3);
        Map<Integer, Integer> lure = new HashMap<>();
        lure.put(1, 15000);
        lure.put(2, 25000);
        lure.put(3, 75000);
        levelCosts.put(Enchantment.LURE, lure);

        // Feather Falling
        maxLevels.put(Enchantment.FEATHER_FALLING, 4);
        Map<Integer, Integer> feather = new HashMap<>();
        feather.put(1, 8000);
        feather.put(2, 12000);
        feather.put(3, 16000);
        feather.put(4, 25000);
        levelCosts.put(Enchantment.FEATHER_FALLING, feather);

        // Depth Strider
        maxLevels.put(Enchantment.DEPTH_STRIDER, 3);
        Map<Integer, Integer> depth = new HashMap<>();
        depth.put(1, 10000);
        depth.put(2, 15000);
        depth.put(3, 20000);
        levelCosts.put(Enchantment.DEPTH_STRIDER, depth);

        // Soul Speed
        maxLevels.put(Enchantment.SOUL_SPEED, 3);
        Map<Integer, Integer> soul = new HashMap<>();
        soul.put(1, 10000);
        soul.put(2, 15000);
        soul.put(3, 20000);
        levelCosts.put(Enchantment.SOUL_SPEED, soul);

        // Swift Sneak
        maxLevels.put(Enchantment.SWIFT_SNEAK, 3);
        Map<Integer, Integer> swift = new HashMap<>();
        swift.put(1, 12000);
        swift.put(2, 18000);
        swift.put(3, 25000);
        levelCosts.put(Enchantment.SWIFT_SNEAK, swift);

    }

    public static int getUpgradeCost(Enchantment enchantment, int level) {
        return levelCosts.getOrDefault(enchantment, new HashMap<>()).getOrDefault(level, -1);
    }
}
