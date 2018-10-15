package com.robertx22.customitems;

import com.robertx22.mmorpg.Ref;
import com.robertx22.saveclasses.GearItemData;
import com.robertx22.saving.Saving;
import com.robertx22.utilityclasses.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

class ArmorBasic extends ItemArmor {

	private ItemArmor.ArmorMaterial mat;
	private EntityEquipmentSlot slot;

	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {

		System.out.println("oncreated");
		GearItemData data = Saving.Load(stack, GearItemData.class);
		if (data != null) {
			System.out.println("data isnt null");

			data.TryRerollComponents();
			Saving.Save(stack, data);
		}

	}

	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public void addInformation(ItemStack stack, @Nullable
	 * World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
	 * 
	 * tooltip.clear(); // doesnt clear everything
	 * 
	 * }
	 * 
	 */
	public ArmorBasic(ArmorMaterial mat, int renderIndexIn, EntityEquipmentSlot slot) {

		super(mat, renderIndexIn, slot);
		this.mat = mat;
		this.slot = slot;
		this.setMaxStackSize(1);
		this.setCreativeTab(NewItemCreator.MyModTab);

		switch (slot) {
		case FEET:
			String boots = mat.getName().substring(Ref.MODID.length() + 1) + "_boots";
			this.setRegistryName(boots);
			this.setUnlocalizedName(Utils.setName(boots));
			break;
		case LEGS:
			String leggings = mat.getName().substring(Ref.MODID.length() + 1) + "_leggings";
			this.setRegistryName(leggings);
			this.setUnlocalizedName(Utils.setName(leggings));
			break;
		case CHEST:
			String chestplate = mat.getName().substring(Ref.MODID.length() + 1) + "_chestplate";
			this.setRegistryName(chestplate);
			this.setUnlocalizedName(Utils.setName(chestplate));
			break;
		case HEAD:
			String helmet = mat.getName().substring(Ref.MODID.length() + 1) + "_helmet";
			this.setRegistryName(helmet);
			this.setUnlocalizedName(Utils.setName(helmet));
			break;
		}
	}

}