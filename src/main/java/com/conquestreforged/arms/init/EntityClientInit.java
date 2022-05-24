package com.conquestreforged.arms.init;

import com.conquestreforged.arms.entities.EntityTypes;
import com.conquestreforged.arms.entities.render.ModelSpear;
import com.conquestreforged.arms.entities.render.RenderSpear;
import com.conquestreforged.arms.items.armor.models.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID)
public class EntityClientInit {
    public static final ModelLayerLocation CRUSADER_HELM_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "crusader_helmet"), "main");
    public static final ModelLayerLocation TOURNEY_KNIGHT_HELM_LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MOD_ID, "tourney_knight_helmet"), "main");


    @SubscribeEvent
    public static void layers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelFlatCrestHelmet.LAYER_LOCATION, ModelFlatCrestHelmet::createHeadLayer);
        event.registerLayerDefinition(ModelWingedHussarBoots.LAYER_LOCATION, ModelWingedHussarBoots::createBodyLayer);
        event.registerLayerDefinition(ModelWingedHussarChest.LAYER_LOCATION, ModelWingedHussarChest::createBodyLayer);
        event.registerLayerDefinition(ModelWingedHussarLegs.LAYER_LOCATION, ModelWingedHussarLegs::createBodyLayer);
        event.registerLayerDefinition(ModelWingedHussarHelmet.LAYER_LOCATION, ModelWingedHussarHelmet::createHeadLayer);
        event.registerLayerDefinition(CRUSADER_HELM_LAYER_LOCATION, ModelGenericHelmet::createHeadLayer);
        event.registerLayerDefinition(TOURNEY_KNIGHT_HELM_LAYER_LOCATION, ModelGenericHelmet::createHeadLayer);
        event.registerLayerDefinition(RenderSpear.modelLayerLocation, ModelSpear::createLayer);
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypes.SPEAR_IRON, RenderSpear::new);
    }
}
