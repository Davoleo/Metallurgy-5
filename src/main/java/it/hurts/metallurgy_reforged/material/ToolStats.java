/*
 * -------------------------------------------------------------------------------------------------------
 * Class: ToolStats
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: ItHurtsLikeHell & Davoleo
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.material;

public class ToolStats {

	private final int toolMagic, harvestLevel, maxUses;
	private final float efficiency, damage;

	//Attributes
	private double maxHealth, movementSpeed, attackDamage, attackSpeed, reachDistance;

	public ToolStats(int toolMagic, int harvestLevel, int maxUses, float efficiency, float damage)
	{
		this.toolMagic = toolMagic;
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.damage = damage;
		this.maxHealth = 0;
		this.movementSpeed = 0;
		this.attackDamage = 0;
		this.attackSpeed = 0;
		this.reachDistance = 0;
	}

	public void setAttributes(double maxHealth, double movementSpeed, double attackDamage, double attackSpeed, double reachDistance)
	{
		this.maxHealth = maxHealth;
		this.movementSpeed = movementSpeed;
		this.attackDamage = attackDamage;
		this.attackSpeed = attackSpeed;
		this.reachDistance = reachDistance;
	}

	//Tool Enchantability
	public int getToolMagic()
	{
		return toolMagic;
	}

	public int getHarvestLevel()
	{
		return harvestLevel;
	}

	public int getMaxUses()
	{
		return maxUses;
	}

	public float getEfficiency()
	{
		return efficiency;
	}

	public float getDamage()
	{
		return damage;
	}

	public double getMaxHealth()
	{
		return maxHealth;
	}

	public double getMovementSpeed()
	{
		return movementSpeed;
	}

	public double getAttackDamage()
	{
		return attackDamage;
	}

	public double getAttackSpeed()
	{
		return attackSpeed;
	}

	public double getReachDistance()
	{
		return reachDistance;
	}

}
