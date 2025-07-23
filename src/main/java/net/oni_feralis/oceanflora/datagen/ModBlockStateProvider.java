package net.oni_feralis.oceanflora.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.oni_feralis.oceanflora.OceanFlora;
import net.oni_feralis.oceanflora.block.ModBlocks;
import net.oni_feralis.oceanflora.block.custom.SeatatoCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OceanFlora.MOD_ID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        makeCrop(((CropBlock) ModBlocks.SEATATO_CROP.get()), "seatato_crop_stage", "seatato_crop_stage");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SeatatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(OceanFlora.MOD_ID, "block/" + textureName + state.getValue(((SeatatoCropBlock) block). getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("oceanflora:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("oceanflora:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
