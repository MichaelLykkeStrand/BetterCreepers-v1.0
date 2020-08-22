/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unbreakable;

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
            Location location = creeper.getLocation();
            if (!creeper.isPowered()) {
                creeper.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 3f, false, false, creeper);
            } else {
                creeper.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 6f, false, false, creeper);
            }
            creeper.remove();
            event.setCancelled(true);
        }
    }
}
