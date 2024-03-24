package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADShortHatZombieVillagerPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADShortHatZombieVillagerPlushBlock> CODEC =
            createCodec(ADShortHatZombieVillagerPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D,
            13.5D, 13.5D, 13.5D);

    public ADShortHatZombieVillagerPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADShortHatZombieVillagerPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
