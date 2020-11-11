package tk.pshub.parangee.skills.plugin

import org.bukkit.Bukkit
import org.bukkit.Particle
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent

class OnProjectileHit(private val pl: Skill) : Listener {
    @EventHandler
    fun onProjectHit(e: ProjectileHitEvent) {
        if (e.entityType != EntityType.TNT) return
        e.hitBlock?.location?.createExplosion(5f)
        Bukkit.getOnlinePlayers().forEach { p ->
            e.entity.location.let { p.spawnParticle(Particle.END_ROD, it, 30) }
        }
    }
}
