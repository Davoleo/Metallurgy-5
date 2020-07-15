/*
 * -------------------------------------------------------------------------------------------------------
 * Class: ModChecker
 * This class is part of Metallurgy 4 Reforged
 * Complete source code is available at: https://github.com/Davoleo/Metallurgy-4-Reforged
 * This code is licensed under GNU GPLv3
 * Authors: Davoleo, ItHurtsLikeHell, PierKnight100
 * Copyright (c) 2020.
 * --------------------------------------------------------------------------------------------------------
 */

package it.hurts.metallurgy_reforged.util;

import net.minecraftforge.fml.common.Loader;

public class ModChecker {

	public static boolean isTConLoaded;
	public static boolean isConarmLoaded;
	public static boolean isIFLoaded;
	public static boolean isProjectELoaded;
	public static boolean isCraftTweakerLoaded;
	public static boolean isSilentGemsLoaded;

	static
	{
		ModChecker.isTConLoaded = Loader.isModLoaded("tconstruct");
		ModChecker.isConarmLoaded = Loader.isModLoaded("conarm");
		ModChecker.isIFLoaded = Loader.isModLoaded("industrialforegoing");
		ModChecker.isProjectELoaded = Loader.isModLoaded("projecte");
		ModChecker.isCraftTweakerLoaded = Loader.isModLoaded("crafttweaker");
		ModChecker.isSilentGemsLoaded = Loader.isModLoaded("silentgems");
	}

}
