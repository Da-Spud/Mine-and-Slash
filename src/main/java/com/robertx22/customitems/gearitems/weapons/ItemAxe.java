package com.robertx22.customitems.gearitems.weapons;

import java.util.HashMap;

import com.robertx22.customitems.gearitems.bases.BaseSwordItem;
import com.robertx22.customitems.gearitems.bases.IWeapon;
import com.robertx22.db_lists.Rarities;
import com.robertx22.uncommon.capability.EntityData.UnitData;
import com.robertx22.uncommon.utilityclasses.RegisterUtils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemAxe extends BaseSwordItem implements IWeapon {
	public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

	public ItemAxe(int rarity, HashMap<Integer, Item> map) {
		super(rarity, map);

	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		Rarities.Items.forEach((x) -> Items.put(x.Rank(), new ItemAxe(x.Rank(), Items)));
		Items.values().forEach((x) -> event.getRegistry().register(x));
	}

	@SubscribeEvent
	public static void onModelRegistry(ModelRegistryEvent event) {
		Items.values().forEach((x) -> RegisterUtils.registerRender(x));
	}

	@Override
	public String Name() {
		return "Axe";
	}

	@Override
	public int GetEnergyCost() {
		return 5;
	}

	@Override
	public boolean Attack(EntityLivingBase source, EntityLivingBase target, UnitData unitsource, UnitData targetUnit) {

		return this.defaultAttack(source, target, unitsource, targetUnit);
	}

}
