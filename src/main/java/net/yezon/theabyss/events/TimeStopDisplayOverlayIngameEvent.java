package net.yezon.theabyss.events;

import net.yezon.theabyss.potion.TimeStopPotionEffectPotionEffect;
import net.yezon.theabyss.TheabyssMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

public class TimeStopDisplayOverlayIngameEvent {

	public static boolean executeEvent(Map<String, Object> dependencies) {
		Entity entity = (Entity) dependencies.get("entity");
		return new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == TimeStopPotionEffectPotionEffect.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity);
	}
}