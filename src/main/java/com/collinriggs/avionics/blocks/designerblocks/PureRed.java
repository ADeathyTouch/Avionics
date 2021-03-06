package com.collinriggs.avionics.blocks.designerblocks;

/**
 * Created by Deathly on 11/19/2016 at 9:39 PM.
 */
import com.collinriggs.avionics.Ref;
import com.collinriggs.avionics.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by Deathly on 11/19/2016.
 */
public class PureRed extends Block {
    public PureRed() {
        super(Material.WOOD);

        setUnlocalizedName("purered");
        setResistance(100F);
        setHardness(0.5F);
        setRegistryName("purered");
        setHarvestLevel("pickaxe", 0);

        setCreativeTab(Ref.avionictab);

        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if (worldIn.isBlockPowered(pos))
        {
            worldIn.setBlockState(pos, ModBlocks.pureredlit.getDefaultState());
        }
        else {
            worldIn.setBlockState(pos, ModBlocks.purered.getDefaultState());
        }

    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        if (worldIn.isBlockPowered(pos))
        {
            worldIn.setBlockState(pos, ModBlocks.pureredlit.getDefaultState());
        }
        else {
            worldIn.setBlockState(pos, ModBlocks.purered.getDefaultState());
        }
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.purered);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.purered);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.purered);
    }
}