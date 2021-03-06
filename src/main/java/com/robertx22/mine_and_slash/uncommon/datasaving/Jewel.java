package com.robertx22.mine_and_slash.uncommon.datasaving;

import com.robertx22.mine_and_slash.saveclasses.item_classes.JewelData;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class Jewel {

    private static final String LOC = "jewel_data";

    public static boolean has(ItemStack stack) {
        return stack.hasTag() && stack.getTag()
            .contains(LOC);
    }

    public static JewelData Load(ItemStack stack) {

        if (stack == null) {
            return null;
        }
        if (!stack.hasTag()) {
            return null;
        }

        return LoadSave.Load(JewelData.class, new JewelData(), stack.getTag(), LOC);

    }

    public static void Save(ItemStack stack, JewelData gem) {

        if (stack == null) {
            return;
        }
        if (!stack.hasTag()) {
            stack.setTag(new CompoundNBT());
        }
        if (gem != null) {
            LoadSave.Save(gem, stack.getTag(), LOC);
        }

    }

}
