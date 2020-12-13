/*==============================================================================
 = Class: ShadowSteelToolEffect
 = This class is part of Metallurgy 4: Reforged
 = Complete source code is available at https://github.com/Davoleo/Metallurgy-4-Reforged
 = This code is licensed under GNU GPLv3
 = Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 = Copyright (c) 2018-2020.
 =============================================================================*/

package it.hurts.metallurgy_reforged.effect.tool;

import it.hurts.metallurgy_reforged.effect.BaseMetallurgyEffect;
import it.hurts.metallurgy_reforged.effect.EnumEffectCategory;
import it.hurts.metallurgy_reforged.material.ModMetals;
import it.hurts.metallurgy_reforged.model.EnumTools;
import it.hurts.metallurgy_reforged.model.LivingEventHandler;
import it.hurts.metallurgy_reforged.util.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Deprecated
public class ShadowSteelToolEffect extends BaseMetallurgyEffect {

	public ShadowSteelToolEffect() {
        super(ModMetals.SHADOW_STEEL);
    }

    @Override
    public EnumEffectCategory getCategory() {
        return EnumEffectCategory.TOOL;
    }

    @Override
    public LivingEventHandler<? extends LivingEvent>[] getEvents() {
        return new LivingEventHandler[0];
    }

    public void playerBreakSpeed(PlayerEvent.BreakSpeed event) {
        EntityPlayer player = event.getEntityPlayer();

        if (isShadowSteelTool(player.getHeldItemMainhand().getItem())) {
            float percentage = Utils.getLightArmorPercentage(player, 100F);
            float speed = event.getNewSpeed() * percentage / 40F;
            event.setNewSpeed(event.getOriginalSpeed() + speed);
		}
	}

	private boolean isShadowSteelTool(Item heldItem)
	{
		return heldItem == metal.getTool(EnumTools.AXE) ||
				heldItem == metal.getTool(EnumTools.PICKAXE) ||
				heldItem == metal.getTool(EnumTools.SHOVEL);
	}

}
