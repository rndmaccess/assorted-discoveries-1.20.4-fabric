package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADCatPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADCatPlushBlock> CODEC = createCodec(ADCatPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.5D, 0.0D, 1.0D, 11.5D,
            9.5D, 14.5D);

    public ADCatPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADCatPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
