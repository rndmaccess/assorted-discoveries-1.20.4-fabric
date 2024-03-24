package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADShulkerPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADShulkerPlushBlock> CODEC = createCodec(ADShulkerPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D,
            14.0D, 12.0D, 14.0D);

    public ADShulkerPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADShulkerPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
