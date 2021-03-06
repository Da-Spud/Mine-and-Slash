package com.robertx22.mine_and_slash.vanilla_mc.blocks.salvage_station;

import com.robertx22.mine_and_slash.vanilla_mc.blocks.bases.BaseInventoryBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockGearSalvage extends BaseInventoryBlock {

    public BlockGearSalvage() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(5F).notSolid());
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {

        return new TileGearSalvage();

    }

}