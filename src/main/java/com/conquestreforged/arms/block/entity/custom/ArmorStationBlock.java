package com.conquestreforged.arms.block.entity.custom;

import com.conquestreforged.arms.screens.ArmorStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class ArmorStationBlock extends Block {
    private static final Component CONTAINER_TITLE = new TranslatableComponent("container.arms_station");

    public ArmorStationBlock(Properties props) {
        super(props);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((p_57074_, p_57075_, p_57076_) -> {
            return new ArmorStationMenu(p_57074_, p_57075_, ContainerLevelAccess.create(level, blockPos));
        }, CONTAINER_TITLE);
    }
}
