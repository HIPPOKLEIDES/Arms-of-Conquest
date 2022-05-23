package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.MenuTypeInit;
import com.conquestreforged.arms.recipe.ArmorStationRecipe;
import com.google.common.collect.Lists;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ArmorStationMenu extends AbstractContainerMenu {
    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private List<ArmorStationRecipe> recipes = Lists.newArrayList();
    private ItemStack input = ItemStack.EMPTY;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {
    };
    public final Container container = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            ArmorStationMenu.this.slotsChanged(this);
            ArmorStationMenu.this.slotUpdateListener.run();
        }
    };
    final ResultContainer resultContainer = new ResultContainer();

    public ArmorStationMenu(int i, Inventory inventory) {
        this(i, inventory, ContainerLevelAccess.NULL);
    }


    public ArmorStationMenu(int p_40297_, Inventory p_40298_, final ContainerLevelAccess p_40299_) {
        super(MenuTypeInit.ARMS_STATION_MENU.get(), p_40297_);
        this.access = p_40299_;
        this.level = p_40298_.player.level;
        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 1, 143, 33) {
            public boolean mayPlace(ItemStack p_40362_) {
                return false;
            }

            public void onTake(Player p_150672_, ItemStack p_150673_) {
                p_150673_.onCraftedBy(p_150672_.level, p_150672_, p_150673_.getCount());
                ArmorStationMenu.this.resultContainer.awardUsedRecipes(p_150672_);
                ItemStack itemstack = ArmorStationMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    ArmorStationMenu.this.setupResultSlot();
                }

                p_40299_.execute((p_40364_, p_40365_) -> {
                    long l = p_40364_.getGameTime();
                    if (ArmorStationMenu.this.lastSoundTime != l) {
                        p_40364_.playSound((Player)null, p_40365_, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        ArmorStationMenu.this.lastSoundTime = l;
                    }

                });
                super.onTake(p_150672_, p_150673_);
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_40298_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_40298_, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }



    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<ArmorStationRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    public boolean stillValid(Player p_40307_) {
        return stillValid(this.access, p_40307_, BlockInit.ARMS_STATION_BLOCK.get());
    }

    public boolean clickMenuButton(Player p_40309_, int p_40310_) {
        if (this.isValidRecipeIndex(p_40310_)) {
            this.selectedRecipeIndex.set(p_40310_);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int p_40335_) {
        return p_40335_ >= 0 && p_40335_ < this.recipes.size();
    }

    public void slotsChanged(Container p_40302_) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(p_40302_, itemstack);
        }

    }

    private void setupRecipeList(Container p_40304_, ItemStack p_40305_) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!p_40305_.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(ArmorStationRecipe.Type.INSTANCE, p_40304_, this.level);
        }

    }

    void setupResultSlot() {
        ItemStack inputStack = this.container.getItem(0);
        int damage = inputStack.getDamageValue();
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(inputStack);
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            ArmorStationRecipe stonecutterrecipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(stonecutterrecipe);
            ItemStack itemStack = stonecutterrecipe.assemble(this.container);
            itemStack.setDamageValue(damage);
            EnchantmentHelper.setEnchantments(map, itemStack);
            this.resultContainer.setItem(0, itemStack);
        } else {
            this.resultContainer.setItem(0, ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return MenuTypeInit.ARMS_STATION_MENU.get();
    }

    public void registerUpdateListener(Runnable p_40324_) {
        this.slotUpdateListener = p_40324_;
    }

    public boolean canTakeItemForPickAll(ItemStack p_40321_, Slot p_40322_) {
        return p_40322_.container != this.resultContainer && super.canTakeItemForPickAll(p_40321_, p_40322_);
    }

    public ItemStack quickMoveStack(Player p_40328_, int p_40329_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_40329_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (p_40329_ == 1) {
                item.onCraftedBy(itemstack1, p_40328_.level, p_40328_);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_40329_ == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(ArmorStationRecipe.Type.INSTANCE, new SimpleContainer(itemstack1), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_40329_ >= 2 && p_40329_ < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_40329_ >= 29 && p_40329_ < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_40328_, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    public void removed(Player p_40326_) {
        super.removed(p_40326_);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(p_40326_, this.container);
        });
    }
}