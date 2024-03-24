package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADRabbitPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADRabbitPlushBlock> CODEC = createCodec(ADRabbitPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.5D, 0.0D, 2.5D, 13.5D,
            10.5D, 13.0D);

    public ADRabbitPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADRabbitPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
