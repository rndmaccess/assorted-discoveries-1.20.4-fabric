package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADCaveSpiderPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADCaveSpiderPlushBlock> CODEC = createCodec(ADCaveSpiderPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 13.5D,
            6.0D, 14.0D);

    public ADCaveSpiderPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADCaveSpiderPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
