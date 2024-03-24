package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADSquidPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADSquidPlushBlock> CODEC = createCodec(ADSquidPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D,
            10.0D, 14.0D);

    public ADSquidPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADSquidPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
