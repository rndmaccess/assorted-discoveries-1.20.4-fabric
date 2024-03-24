package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADMooshroomPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADMooshroomPlushBlock> CODEC = createCodec(ADMooshroomPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 1.0D, 12.5D,
            14.0D, 15.0D);

    public ADMooshroomPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADMooshroomPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
