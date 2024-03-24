package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADDesertVillagerPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADDesertVillagerPlushBlock> CODEC = createCodec(ADDesertVillagerPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 3.5D, 13.0D,
            14.5D, 13.0D);

    public ADDesertVillagerPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADDesertVillagerPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
