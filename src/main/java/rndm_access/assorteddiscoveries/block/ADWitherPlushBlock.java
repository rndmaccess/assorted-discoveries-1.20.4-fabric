package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADWitherPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADWitherPlushBlock> CODEC = createCodec(ADWitherPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(2.5, 0.0, 3.5, 13.5,
            13.5, 12.5);

    public ADWitherPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADWitherPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
