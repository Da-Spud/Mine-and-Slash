package com.robertx22.mine_and_slash.uncommon.capability.world;

import com.robertx22.mine_and_slash.config.forge.ModConfig;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.new_content.building.DungeonUtils;
import com.robertx22.mine_and_slash.saveclasses.dungeon_dimension.DungeonData;
import com.robertx22.mine_and_slash.saveclasses.dungeon_dimension.DungeonDimensionData;
import com.robertx22.mine_and_slash.saveclasses.item_classes.MapItemData;
import com.robertx22.mine_and_slash.uncommon.Statics;
import com.robertx22.mine_and_slash.uncommon.capability.bases.BaseProvider;
import com.robertx22.mine_and_slash.uncommon.capability.bases.BaseStorage;
import com.robertx22.mine_and_slash.uncommon.capability.bases.ICommonCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.base.LoadSave;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.WorldUtils;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class WorldMapCap {

    public static final ResourceLocation RESOURCE = new ResourceLocation(Ref.MODID, "adventure_map");

    @CapabilityInject(IWorldMapData.class)
    public static final Capability<IWorldMapData> Data = null;

    public interface IWorldMapData extends ICommonCap {

        float getLootMultiplier(BlockPos pos, IWorld world);

        float getExpMultiplier(BlockPos pos, IWorld world);

        int getLevel(BlockPos pos, IWorld world);

        int getTier(BlockPos pos, IWorld world);

        MapItemData getMap(BlockPos pos, IWorld world);

        void init(MapItemData map, ChunkPos pos);

        boolean shouldDeleteFolderOnServerShutdown();

        DungeonDimensionData getData();
    }

    @Mod.EventBusSubscriber
    public static class EventHandler {

        @SubscribeEvent
        public static void onEntityConstruct(AttachCapabilitiesEvent<World> event) {
            event.addCapability(RESOURCE, new Provider());
        }

    }

    public static class Provider extends BaseProvider<IWorldMapData> {

        @Override
        public IWorldMapData defaultImpl() {
            return new DefaultImpl();
        }

        @Override
        public Capability<IWorldMapData> dataInstance() {
            return Data;
        }
    }

    static String DATA_LOC = Ref.MODID + ":data";

    public static class DefaultImpl implements IWorldMapData {

        DungeonDimensionData data = new DungeonDimensionData();

        @Override
        public CompoundNBT saveToNBT() {

            CompoundNBT nbt = new CompoundNBT();

            if (data != null) {
                LoadSave.Save(data, nbt, DATA_LOC);
            }

            return nbt;

        }

        @Override
        public void loadFromNBT(CompoundNBT nbt) {

            data = LoadSave.Load(DungeonDimensionData.class, new DungeonDimensionData(), nbt, DATA_LOC);

            if (data == null) {
                data = new DungeonDimensionData();
            }

        }

        @Override
        public void init(MapItemData map, ChunkPos pos) {

            ChunkPos cpos = DungeonUtils.getStartChunk(pos);

            DungeonData d = new DungeonData();
            d.mapData = map;
            data.setupNew(d, cpos);

        }

        @Override
        public boolean shouldDeleteFolderOnServerShutdown() {
            return data.getDungeonsAmount() > ModConfig.INSTANCE.Server.DELETE_DUNGEON_DIMENSION_FOLDER_AFTER_X_MAPS_SACRIFICED.get();
        }

        @Override
        public DungeonDimensionData getData() {
            return data;
        }

        @Override
        public float getLootMultiplier(BlockPos pos, IWorld world) {
            return this.getMap(pos, world)
                .getBonusLootMulti();

        }

        @Override
        public float getExpMultiplier(BlockPos pos, IWorld world) {
            return (1 + getMap(pos, world).tier * 0.05F) * getMap(pos, world).getBonusExpMulti();
        }

        @Override
        public int getLevel(BlockPos pos, IWorld world) {
            return this.getMap(pos, world).level;
        }

        @Override
        public int getTier(BlockPos pos, IWorld world) {
            return this.getMap(pos, world).tier;
        }

        @Override
        public MapItemData getMap(BlockPos pos, IWorld world) {

            if (pos.equals(Statics.EMPTY_POS)) {
                return MapItemData.empty();
            }

            try {
                return data.getData(pos).mapData;
            } catch (Exception e) {
                System.out.println("Failed getting map data for pos: " + pos.toString());
            }

            System.out.println("No data map found, returning blank default.");
            return MapItemData.empty();

        }

    }

    public static class Storage extends BaseStorage<IWorldMapData> {

    }

}
