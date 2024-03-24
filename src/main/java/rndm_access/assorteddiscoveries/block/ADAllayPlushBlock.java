package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADAllayPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADAllayPlushBlock> CODEC = createCodec(ADAllayPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 13.0D,
            10.0D, 13.0D);

    public ADAllayPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADAllayPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
