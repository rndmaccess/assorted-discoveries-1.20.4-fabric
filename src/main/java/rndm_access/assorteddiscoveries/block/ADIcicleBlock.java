package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.Thickness;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import rndm_access.assorteddiscoveries.core.ADBlocks;

public class ADIcicleBlock extends Block implements LandingBlock, Waterloggable {
    public static final DirectionProperty VERTICAL_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final EnumProperty<Thickness> THICKNESS = Properties.THICKNESS;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final int MAX_ICICLE_GROWTH = 7;
    private static final int ICICLE_FLOOR_SEARCH_RANGE = 10;
    private static final VoxelShape SHAPE = Block.createCuboidShape(4.0, 1.0, 4.0, 12.0,
            16.0, 12.0);

    public ADIcicleBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(VERTICAL_DIRECTION, Direction.UP).with(THICKNESS, Thickness.TIP).with(WATERLOGGED, false));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VERTICAL_DIRECTION, THICKNESS, WATERLOGGED);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return canPlaceAtWithDirection(world, pos, state.get(VERTICAL_DIRECTION));
    }

    private static boolean canPlaceAtWithDirection(WorldView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, direction) || isIcicleFacingDirection(blockState, direction);
    }

    private static boolean isIcicleFacingDirection(BlockState state, Direction direction) {
        return state.isOf(ADBlocks.ICICLE) && state.get(VERTICAL_DIRECTION) == direction;
    }

    private static boolean isTip(BlockState state, boolean allowMerged) {
        if (!state.isOf(ADBlocks.ICICLE)) {
            return false;
        } else {
            Thickness thickness = state.get(THICKNESS);
            return thickness == Thickness.TIP || allowMerged && thickness == Thickness.TIP_MERGE;
        }
    }

    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        BlockPos blockPos = hit.getBlockPos();
        if (!world.isClient && projectile.canModifyAt(world, blockPos) && projectile instanceof TridentEntity
                && projectile.getVelocity().length() > 0.6) {
            world.breakBlock(blockPos, true);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.damage(world.getDamageSources().freeze(), 0.5F);
    }

    /*
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double x = pos.getX() + random.nextDouble();
        double y = pos.getY() + random.nextDouble();
        double z = pos.getZ() + random.nextDouble();

        if(random.nextFloat() < 0.5) {
            world.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0.0D, 0.001D, 0.0D);
        }
    }
    */
}
