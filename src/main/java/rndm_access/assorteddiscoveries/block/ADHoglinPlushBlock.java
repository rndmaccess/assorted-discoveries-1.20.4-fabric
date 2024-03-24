package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADHoglinPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADHoglinPlushBlock> CODEC = createCodec(ADHoglinPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.0, 0.0, 1.0, 12.0,
            9.0, 15.0);

    public ADHoglinPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADHoglinPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
