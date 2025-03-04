package one.tranic.deh;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Event implements Listener {
    @EventHandler
    public void onItemDespawn(ItemDespawnEvent event) {
        Item item = event.getEntity();
        ItemStack itemStack = item.getItemStack();
        if (!itemStack.getType().equals(Material.EGG)) {
            return;
        }
        World world = item.getWorld();

        if (Config.isEggOnlyHatchesWhenOnTopOfHayBlock()) {
            Block belowBlock = item.getLocation().getBlock().getRelative(0, -1, 0);
            if (!belowBlock.getType().equals(Material.HAY_BLOCK)) {
                return;
            }
        }

        double num = ThreadLocalRandom.current().nextDouble();
        if (num > Config.getEggWillHatchChance()) return;

        int itemAmount = itemStack.getAmount();
        int mobLimit = Config.getOnlyHatchIfLessChickensAroundThan() ;

        Location location = item.getLocation();
        int radius = Config.getRadiusEntityLimiterCheck();

        List<Entity> nearbyEntities = (List<Entity>) world.getNearbyEntities(location, radius, radius, radius);
        int chickenCount = 0;

        for (Entity entity : nearbyEntities) if (entity instanceof Chicken) chickenCount++;

        for (int i = 0; i < itemAmount; i++) {
            if (chickenCount > mobLimit) return;

            Chicken chicken = (Chicken) world.spawnEntity(location, EntityType.CHICKEN);
            if (Config.isNewHatchlingIsBaby()) chicken.setBaby();

            chickenCount++;
        }
    }
}
