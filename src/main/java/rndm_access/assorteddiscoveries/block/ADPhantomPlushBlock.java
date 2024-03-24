package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADPhantomPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADPhantomPlushBlock> CODEC = createCodec(ADPhantomPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.5, 0.0, 0.0, 13.5,
            5.0, 14.0);

    public ADPhantomPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADPhantomPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
