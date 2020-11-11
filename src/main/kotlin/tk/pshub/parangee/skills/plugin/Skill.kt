package tk.pshub.parangee.skills.plugin

import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.entity.EntityType
import org.bukkit.plugin.java.JavaPlugin

class Skill:JavaPlugin() {
    override fun onEnable() {
        println("skill enabled")
        server.pluginManager.registerEvents(OnProjectileHit(this), this)
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, Runnable {
            Bukkit.getWorlds().forEach {world ->
                world.entities.forEach {
                    if (it.type == EntityType.TNT) {
                        Bukkit.getOnlinePlayers().forEach { p ->
                            p.spawnParticle(Particle.LAVA, it.location, 1)
                        }
                    }
                }
            }
        }, 0, 1)
    }
}
