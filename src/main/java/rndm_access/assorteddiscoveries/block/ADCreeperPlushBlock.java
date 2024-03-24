package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADCreeperPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADCreeperPlushBlock> CODEC = createCodec(ADCreeperPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 2.0D, 12.0D,
            12.0D, 14.0D);

    public ADCreeperPlushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADCreeperPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
