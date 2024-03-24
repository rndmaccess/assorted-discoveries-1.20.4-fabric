package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADVillagerPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADVillagerPlushBlock> CODEC = createCodec(ADVillagerPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 3.5D, 13.0D,
            12.5D, 13.0D);

    public ADVillagerPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADVillagerPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
