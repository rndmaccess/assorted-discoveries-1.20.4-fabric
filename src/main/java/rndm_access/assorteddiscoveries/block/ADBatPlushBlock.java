package rndm_access.assorteddiscoveries.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public class ADBatPlushBlock extends ADAbstractSimplePlushBlock {
    public static final MapCodec<ADBatPlushBlock> CODEC = createCodec(ADBatPlushBlock::new);
    private static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 4.0D, 15.0D,
            12.0D, 12.0D);

    public ADBatPlushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<ADBatPlushBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getNorthShape() {
        return NORTH_SHAPE;
    }
}
