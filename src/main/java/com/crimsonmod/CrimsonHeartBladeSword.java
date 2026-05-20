package com.crimsonmod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;

public class CrimsonHeartBladeSword extends SwordItem {
    public CrimsonHeartBladeSword(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties.durability(900));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slotIndex, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (isSelected) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
            }
        }
        super.inventoryTick(stack, level, entity, slotIndex, isSelected);
    }
}
