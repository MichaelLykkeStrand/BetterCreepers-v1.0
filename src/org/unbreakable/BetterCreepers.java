/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unbreakable;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Unbreakable
 */
public class BetterCreepers extends JavaPlugin{
    
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new ExplosionPrimeListener(), this);
    }

    
    @Override
    public void onDisable(){ 
    }
}
