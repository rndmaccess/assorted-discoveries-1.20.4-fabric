package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADCamelPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADCamelPlushBlock> CODEC = createCodec(ADCamelPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 1.0D, 14.0D,
            12.0D, 15.0D);

    public ADCamelPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADCamelPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
