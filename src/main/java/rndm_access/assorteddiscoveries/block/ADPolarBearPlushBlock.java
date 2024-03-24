package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADPolarBearPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADPolarBearPlushBlock> CODEC = createCodec(ADPolarBearPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 2.5D, 12.5D,
            11.5D, 14.5D);

    public ADPolarBearPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADPolarBearPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
