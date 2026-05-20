package com.steinlane.crimsonmod.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.nbt.Tag;

public class CrimsonHeartBlade extends SwordItem {
    
    public CrimsonHeartBlade(Tier tier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
    
    @Override
    public void inventoryTick(ItemStack stack, net.minecraft.world.level.Level level, Entity entity, int slotIndex, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotIndex, isSelected);
        
        if (entity instanceof Player player && !level.isClientSide) {
            // Check if the sword is being held
            if (isSelected || player.getOffhandItem() == stack) {
                // Apply invisibility effect
                player.addEffect(new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.INVISIBILITY,
                    20, // duration in ticks (1 second)
                    0,  // amplifier
                    false, // ambient
                    false // show particles
                ));
            }
        }
    }
}
