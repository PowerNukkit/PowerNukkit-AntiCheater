package org.powernukkit.plugins.example;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityHuman;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;

public class CloneListener implements Listener {
    @EventHandler
    public void onCloneDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        
        // Affect only the clones
        if (!(entity instanceof EntityHuman)
                || !entity.namedTag.getBoolean("IsCloned")) {
            return;
        }
        
        // Makes the clones invulnerable to non-player damage
        if (!(event.getDamager() instanceof Player)) {
            event.setCancelled();
            return;
        }
        
        // If the clone is hit by a player, despawn it
        Player player = (Player) event.getDamager();
        player.sendMessage(TextFormat.GOLD+""+TextFormat.BOLD+"WOW!"+TextFormat.RESET+TextFormat.YELLOW+" You found a clone!");
        entity.close();
        
        // And give the player a present
        Item flowerItem = Item.getBlock(BlockID.RED_FLOWER);
        flowerItem.setCustomName(TextFormat.RESET+""+TextFormat.RED+"Congratulations!");
        flowerItem.setLore(TextFormat.RESET+""+TextFormat.LIGHT_PURPLE+"This is a present for your finding!");
        
        // The will guarantee that the player receive the present by dropping it on the floor if the inventory is full 
        for (Item drop: player.getInventory().addItem(flowerItem)) {
            player.getLevel().dropItem(player, drop);
        }
    }
}
