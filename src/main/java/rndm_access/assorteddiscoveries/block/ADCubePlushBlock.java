package rndm_access.assorteddiscoveries.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import rndm_access.assorteddiscoveries.block.state.ADProperties;
import rndm_access.assorteddiscoveries.util.ADShapeHelper;

import java.util.HashMap;
import java.util.Objects;

public class ADCubePlushBlock extends ADPlushBlock {
    public static final IntProperty STACK_SIZE = ADProperties.STACK_SIZE;
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

    private static final VoxelShape NORTH_BOTTOM_SHAPE = Block.createCuboidShape(2.5D, 0.0D, 2.5D,
            13.5D, 9.5D, 13.5D);
    private static final HashMap<Direction, VoxelShape> BOTTOM_SHAPES = ADShapeHelper.makeShapeRotMap(NORTH_BOTTOM_SHAPE);

    private static final VoxelShape NORTH_TEMP_MIDDLE_SHAPE = Block.createCuboidShape(3.5D, 7.0D,
            3.5D, 12.5D, 16.5D, 12.5D);
    private static final VoxelShape NORTH_MIDDLE_SHAPE = VoxelShapes.union(NORTH_BOTTOM_SHAPE, NORTH_TEMP_MIDDLE_SHAPE);
    private static final HashMap<Direction, VoxelShape> MIDDLE_SHAPES = ADShapeHelper.makeShapeRotMap(NORTH_MIDDLE_SHAPE);

    private static final VoxelShape NORTH_TOP_SHAPE = Block.createCuboidShape(5.5D, 0.0D, 5.5D,
            10.5D, 4.5D, 10.5D);
    private static final HashMap<Direction, VoxelShape> TOP_SHAPES = ADShapeHelper.makeShapeRotMap(NORTH_TOP_SHAPE);

    public ADCubePlushBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER).with(STACK_SIZE, 1)
                .with(WATERLOGGED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        BlockState state = world.getBlockState(pos);

        if (this.isCubePlush(state)) {
            return state.with(STACK_SIZE, this.getNextStackSize(state));
        }
        return super.getPlacementState(context);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        FluidState fluidState = world.getFluidState(pos);

        // Top off the stack with the final cube plush.
        if (this.isTripleStacked(state)) {
            BlockState cubePlush = state.with(HALF, DoubleBlockHalf.UPPER).with(STACK_SIZE, 3)
                    .with(WATERLOGGED, this.isWaterSource(fluidState));

            world.setBlockState(pos.up(), cubePlush, 3);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        BlockPos abovePos = context.getBlockPos().up();
        BlockState aboveState = context.getWorld().getBlockState(abovePos);

        return (this.isCubePlush(context) && this.isStackWithinOneBlock(state))
                || (this.isCubePlush(context) && aboveState.isReplaceable() && this.isDoubleStacked(state));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState,
                                                WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if(this.canStay(state, world, pos)) {
            return state;
        } else {
            return Blocks.AIR.getDefaultState();
        }
    }

    private boolean canStay(BlockState state, WorldView world, BlockPos pos) {
        BlockState belowState = world.getBlockState(pos.down());
        BlockState aboveState = world.getBlockState(pos.up());

        if(this.isTripleStacked(state)) {
            return this.isCubePlush(belowState) && this.isUpperHalf(state)
                    || this.isCubePlush(aboveState) && this.isLowerHalf(state);
        } else {
            return true;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        VoxelShape bottomShape = BOTTOM_SHAPES.get(direction);
        VoxelShape middleShape = MIDDLE_SHAPES.get(direction);
        VoxelShape topShape = TOP_SHAPES.get(direction);

        return switch (state.get(STACK_SIZE)) {
            case 1 -> bottomShape;
            case 2 -> middleShape;
            default -> (this.isUpperHalf(state) ? topShape : middleShape);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STACK_SIZE, HALF, WATERLOGGED, FACING);
    }

    private boolean isCubePlush(ItemPlacementContext context) {
        return context.getStack().isOf(this.asItem());
    }

    private boolean isCubePlush(BlockState state) {
        return state.isOf(this);
    }

    private boolean isStackWithinOneBlock(BlockState state) {
        return state.get(STACK_SIZE) < 2;
    }

    private boolean isDoubleStacked(BlockState state) {
        return Objects.equals(state.get(STACK_SIZE), 2);
    }

    private boolean isTripleStacked(BlockState state) {
        return Objects.equals(state.get(STACK_SIZE), 3);
    }

    private boolean isUpperHalf(BlockState state) {
        return Objects.equals(state.get(HALF), DoubleBlockHalf.UPPER);
    }

    private boolean isLowerHalf(BlockState state) {
        return Objects.equals(state.get(HALF), DoubleBlockHalf.LOWER);
    }

    private boolean isWaterSource(FluidState fluidState) {
        return fluidState.isIn(FluidTags.WATER) && fluidState.isStill();
    }

    private int getNextStackSize(BlockState state) {
        return Math.min(3, state.get(STACK_SIZE) + 1);
    }
}
