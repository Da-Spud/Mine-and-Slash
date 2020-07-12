package com.robertx22.mine_and_slash.database.gearitemslots.leather;

import com.robertx22.mine_and_slash.database.StatModifier;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.armor.BaseChest;
import com.robertx22.mine_and_slash.database.stats.types.defense.DodgeRating;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ModItems;
import com.robertx22.mine_and_slash.uncommon.enumclasses.ModType;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public class LeatherLeggings extends BaseChest {
    public static GearItemSlot INSTANCE = new LeatherLeggings();

    private LeatherLeggings() {

    }

    @Override
    public List<StatModifier> BaseStats() {
        return Arrays.asList(
            new StatModifier(45, 80, DodgeRating.getInstance(), ModType.FLAT)
        );
    }

    @Override
    public List<StatModifier> ImplicitStats() {
        return Arrays.asList();
    }

    @Override
    public List<SlotTag> getTags() {
        return Arrays.asList(SlotTag.Leather, SlotTag.Pants);
    }

    @Override
    public Item getItem() {
        return ModItems.LEATHER_LEGGINGS.get();
    }

    @Override
    public String GUID() {
        return "leather_leggings";
    }

    @Override
    public PlayStyle getPlayStyle() {
        return PlayStyle.DEX;
    }

    @Override
    public String locNameForLangFile() {
        return "Leather Leggings";
    }

}
