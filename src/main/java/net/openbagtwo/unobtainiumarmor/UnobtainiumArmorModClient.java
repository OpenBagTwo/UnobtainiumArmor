package net.openbagtwo.unobtainiumarmor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.SpitParticle;
import net.minecraft.item.Item;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.entity.client.armor.MythrilArmorRenderer;
import net.openbagtwo.unobtainiumarmor.factory.ArmorItemFactory;
import net.openbagtwo.unobtainiumarmor.items.Armors;
import net.openbagtwo.unobtainiumarmor.particle.RegisterParticles;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import java.util.ArrayList;
import java.util.Map;

public class UnobtainiumArmorModClient implements ClientModInitializer {

    public static Item[] getArmorItems(Map<String, Item> group){
        ArrayList<Item> armorItems = new ArrayList<>();
        for (Map.Entry<String, Item> item : group.entrySet()){
            String[] parsed = item.getKey().split("_");
            if (ArmorItemFactory.SLOT_MAP.containsValue(parsed[parsed.length - 1])){
                armorItems.add(item.getValue());
            }
        }
        return armorItems.toArray(new Item[0]);
    }

    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(UnobtainiumArmorMod.MOD_ID, "particle/f_ray"));
        }));

        ParticleFactoryRegistry.getInstance().register(RegisterParticles.F_RAY, SpitParticle.Factory::new);

        GeoArmorRenderer.registerArmorRenderer(
                MythrilArmorRenderer.MYTHRIL,
                getArmorItems(Armors.MYTHRIL)
        );
        GeoArmorRenderer.registerArmorRenderer(
                MythrilArmorRenderer.createMythrilRenderer("cythril"),
                getArmorItems(Armors.CYTHRIL)
        );

        GeoArmorRenderer.registerArmorRenderer(
                MythrilArmorRenderer.createMythrilRenderer("topaz"),
                getArmorItems(Armors.TOPAZ)
        );
    }
}
