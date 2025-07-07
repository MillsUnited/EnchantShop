package com.mills.enchantShop;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class EnchantsGUI implements Listener {

    private static String itemName;

    public static Inventory enchantsGUI(Player player) {
        getItem(player);
        if (itemName == null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lEnchants &8» &7You must be holding an enchantable item!"));
            return null;
        }

        Inventory inv = Bukkit.createInventory(player, 54, "Enchants » " + itemName);
        ItemStack item = player.getInventory().getItemInMainHand();
        inv.setItem(13, item);

        // Filler panes
        ItemStack panes = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta paneMeta = panes.getItemMeta();
        paneMeta.setDisplayName(" ");
        panes.setItemMeta(paneMeta);
        for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,34,35,36,37,43,44,45,46,47,48,49,50,51,52,53}) {
            inv.setItem(i, panes);
        }

        int[] ENCHANT_SLOTS = {29, 30, 31, 32, 33, 38, 39, 40, 41, 42};
        int slotIndex = 0;

        for (Map.Entry<Enchantment, Integer> entry : EnchantData.maxLevels.entrySet()) {
            if (slotIndex >= ENCHANT_SLOTS.length) break;

            Enchantment enchant = entry.getKey();
            if (!enchant.canEnchantItem(item)) continue;

            int currentLevel = item.getEnchantmentLevel(enchant);
            int maxLevel = entry.getValue();
            int nextLevel = currentLevel + 1;

            String name;
            List<String> lore;

            if (currentLevel >= maxLevel) {
                name = ChatColor.AQUA + Utils.format(enchant.getKey().getKey()) + ChatColor.GRAY + " (Max)";
                lore = List.of(" ", ChatColor.RED + "Already at max level!");
            } else {
                int cost = EnchantData.getUpgradeCost(enchant, nextLevel);
                if (cost < 0) continue; // Skip if cost not defined

                name = ChatColor.AQUA + Utils.format(enchant.getKey().getKey() + " " + nextLevel);
                lore = List.of(
                        " ",
                        ChatColor.GRAY + "Upgrade cost: " + ChatColor.GREEN + cost + " EXP",
                        " ",
                        ChatColor.translateAlternateColorCodes('&', "&a&l(!) &aClick to purchase!")
                );
            }

            ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta meta = book.getItemMeta();
            meta.setDisplayName(name);
            meta.setLore(lore);
            book.setItemMeta(meta);

            inv.setItem(ENCHANT_SLOTS[slotIndex++], book);
        }

        player.openInventory(inv);
        return inv;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        if (e.getView().getTitle().contains("Enchants »")) {
            e.setCancelled(true);

            ItemMeta meta = clickedItem.getItemMeta();
            if (meta == null || !meta.hasDisplayName()) return;

            String displayName = meta.getDisplayName();
            String[] parts = ChatColor.stripColor(displayName).split(" ");
            if (parts.length < 2) return;

            String levelPart = parts[parts.length - 1].replaceAll("[^0-9]", "");
            if (levelPart.isEmpty()) {
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
                return;
            }

            int nextLevel = Integer.parseInt(levelPart);
            String enchantmentName = String.join("_", Arrays.copyOfRange(parts, 0, parts.length - 1)).toLowerCase();
            Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(enchantmentName));

            if (enchantment == null) return;
            int cost = EnchantData.getUpgradeCost(enchantment, nextLevel);

            if (cost < 0) return;

            int playerXP = Utils.getTotalExperience(player);

            if (playerXP >= cost) {
                ItemStack itemInHand = player.getInventory().getItemInMainHand();
                itemInHand.addEnchantment(enchantment, nextLevel);

                int newXP = Math.max(0, playerXP - cost);
                player.setExp(newXP);

                enchantsGUI(player);
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0f, 1.0f);
            } else {
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
            }
        }
    }

    private static void getItem(Player player) {
        Material itemType = player.getInventory().getItemInMainHand().getType();
        switch (itemType) {
            case NETHERITE_SWORD:
            case DIAMOND_SWORD:
            case IRON_SWORD:
            case STONE_SWORD:
            case WOODEN_SWORD:
            case GOLDEN_SWORD:
                itemName = "Sword";
                break;
            case NETHERITE_AXE:
            case DIAMOND_AXE:
            case IRON_AXE:
            case STONE_AXE:
            case WOODEN_AXE:
            case GOLDEN_AXE:
                itemName = "Axe";
                break;
            case NETHERITE_PICKAXE:
            case DIAMOND_PICKAXE:
            case IRON_PICKAXE:
            case STONE_PICKAXE:
            case WOODEN_PICKAXE:
            case GOLDEN_PICKAXE:
                itemName = "Pickaxe";
                break;
            case NETHERITE_SHOVEL:
            case DIAMOND_SHOVEL:
            case IRON_SHOVEL:
            case STONE_SHOVEL:
            case WOODEN_SHOVEL:
            case GOLDEN_SHOVEL:
                itemName = "Shovel";
                break;
            case NETHERITE_HOE:
            case DIAMOND_HOE:
            case IRON_HOE:
            case STONE_HOE:
            case WOODEN_HOE:
            case GOLDEN_HOE:
                itemName = "Hoe";
                break;
            case NETHERITE_HELMET:
            case DIAMOND_HELMET:
            case IRON_HELMET:
            case CHAINMAIL_HELMET:
            case LEATHER_HELMET:
            case GOLDEN_HELMET:
                itemName = "Helmet";
                break;
            case NETHERITE_CHESTPLATE:
            case DIAMOND_CHESTPLATE:
            case IRON_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case LEATHER_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
                itemName = "Chestplate";
                break;
            case NETHERITE_LEGGINGS:
            case DIAMOND_LEGGINGS:
            case IRON_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case LEATHER_LEGGINGS:
            case GOLDEN_LEGGINGS:
                itemName = "Legging";
                break;
            case NETHERITE_BOOTS:
            case DIAMOND_BOOTS:
            case IRON_BOOTS:
            case CHAINMAIL_BOOTS:
            case LEATHER_BOOTS:
            case GOLDEN_BOOTS:
                itemName = "Boots";
                break;
            case BOW:
                itemName = "Bow";
                break;
            case CROSSBOW:
                itemName = "Crossbow";
                break;
            case SHIELD:
                itemName = "Shield";
                break;
            case FISHING_ROD:
                itemName = "Fishing Rod";
                break;
            default:
                itemName = null;
        }
    }
}
