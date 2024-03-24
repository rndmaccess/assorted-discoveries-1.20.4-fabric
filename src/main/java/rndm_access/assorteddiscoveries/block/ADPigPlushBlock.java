package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADPigPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADPigPlushBlock> CODEC = createCodec(ADPigPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 1.0D, 12.0D,
            12.0D, 15.0D);

    public ADPigPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADPigPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
