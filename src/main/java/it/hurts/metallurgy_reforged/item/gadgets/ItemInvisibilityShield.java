/*
 * -------------------------------------------------------------------------------------------------------
 * Class: ItemInvisibilityShield
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2019.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.item.gadgets;

import it.hurts.metallurgy_reforged.item.ItemBase;
import it.hurts.metallurgy_reforged.util.MetallurgyTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemInvisibilityShield extends ItemBase {

    public ItemInvisibilityShield()
    {
        super("lemurite_shield");
        setMaxStackSize(1);
        setCreativeTab(MetallurgyTabs.tabSpecial);
        setMaxDamage(250);

        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(@Nonnull ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });

    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity)
    {
        return true;
    }

    @Override
    public int getItemEnchantability()
    {
        return 25;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 600;
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand handIn)
    {
        playerIn.setInvisible(true);
        playerIn.setActiveHand(handIn);
        spawnParticles(playerIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        terminateEffect(entityLiving, stack, 600 - timeLeft);
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count)
    {
        if (count <= 1)
            terminateEffect(player, stack, 600);
    }

    private void terminateEffect(EntityLivingBase player, ItemStack stack, int cooldown)
    {
        player.setInvisible(false);
        ((EntityPlayer) player).getCooldownTracker().setCooldown(stack.getItem(), cooldown);
        spawnParticles(player);
    }

    private void spawnParticles(EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayerMP)
            ((EntityPlayerMP) entity).connection.sendPacket(new SPacketParticles(EnumParticleTypes.EXPLOSION_LARGE, true, (float) entity.posX , (float) entity.posY + 1, (float) entity.posZ, 0, 0, 0, 0, 1, 0));
    }

    @Override
    public void registerItemModel(String subdirectory)
    {
        super.registerItemModel("gadget");
    }

    @Nonnull
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
}