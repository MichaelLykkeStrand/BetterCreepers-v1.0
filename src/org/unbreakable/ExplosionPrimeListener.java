/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unbreakable;

import static org.bukkit.Bukkit.getLogger;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

/**
 *
 * @author Unbreakable
 */
public class ExplosionPrimeListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    void ExplosionPrimeEvent(ExplosionPrimeEvent event) {
        Entity e = event.getEntity();
        if (e instanceof Creeper) {
            Creeper creeper = (Creeper) e;
            if (!creeper.isPowered()) {
                Location location = creeper.getLocation();
                creeper.remove();
                creeper.getWorld().createExplosion(location, 3f, false, false);
                event.setCancelled(true);
            }
        }
    }
}
