package com.robertx22.mine_and_slash.new_content_test.professions.blocks;

import com.robertx22.mine_and_slash.new_content_test.professions.recipe.BaseRecipe;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;

import java.util.List;

public abstract class ProfessionRecipesTile extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

    public NonNullList<ItemStack> recipeStacks;

    ItemStack[] materialStacks;

    ItemStack[] outputStacks;

    public ProfessionRecipesTile(TileEntityType<?> type) {
        super(type);
        recipeStacks = NonNullList.withSize(6 * 9, ItemStack.EMPTY);
    }

    @Override
    public void tick() {

    }

    public abstract List<BaseRecipe> recipes();

    public void scrollToRow(int row) {
        for (int i = row * 9; i < row * 9 + ProfessionContainer.size; i++) {
            this.recipeStacks.set(i, recipes().get(i).getOutput(this).getPreview());
        }
    }

}
