package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADGuardianPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADGuardianPlushBlock> CODEC = createCodec(ADGuardianPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(3.5D, 0.0D, 2.5D, 12.5D,
            8.5D, 12.5D);

    public ADGuardianPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADGuardianPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
