package com.robertx22.crafting;

import com.robertx22.saveclasses.GearItemData;
import com.robertx22.saving.Saving;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class RecipeUtils {

	public static ItemStack AnyItemIsGearItem(InventoryCrafting inv) {

		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);

			GearItemData data = Saving.Load(stack, GearItemData.class);
			if (data != null) {
				return stack;
			}

		}

		return null;
	}

}
