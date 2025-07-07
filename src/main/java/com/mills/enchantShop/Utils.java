package com.mills.enchantShop;

import org.bukkit.entity.Player;

public class Utils {

    public static String format(String string) {

        StringBuilder builder = new StringBuilder();

        for (String word : string.split("_")) {
            String first = word.substring(0, 1);
            String second = word.substring(1);

            builder.append(first.toUpperCase()).append(second.toLowerCase()).append(" ");
        }

        return builder.toString().trim();
    }

    public static int getTotalExperience(Player player) {
        int level = player.getLevel();
        float progress = player.getExp();
        int xp = 0;

        for (int i = 0; i < level; i++) {
            if (i >= 30) {
                xp += 112 + (i - 30) * 9;
            } else if (i >= 15) {
                xp += 37 + (i - 15) * 5;
            } else {
                xp += 7 + i * 2;
            }
        }

        int expToNextLevel;
        if (level >= 30) {
            expToNextLevel = 112 + (level - 30) * 9;
        } else if (level >= 15) {
            expToNextLevel = 37 + (level - 15) * 5;
        } else {
            expToNextLevel = 7 + level * 2;
        }

        xp += Math.round(progress * expToNextLevel);
        return xp;
    }

}
