package com.dimalab.dimalabmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import static com.dimalab.dimalabmod.DimaLabMod.MODID;


public class JustScreenKeyboard {
    private static final KeyBinding OPEN_EVENT_LIST;

    private static  final String KEY_CATEGORY_MOD = String.format("key.categories.mod.%s", MODID);

    static {
        OPEN_EVENT_LIST = new KeyBinding(keyBindName("event_list"), 342, KEY_CATEGORY_MOD);
    }

    private static String keyBindName(String name) {
        return String.format("key.%s.%s", MODID, name);
    }

    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (OPEN_EVENT_LIST.isActiveAndMatches(InputMappings.getKey(event.getKey(), event.getScanCode())) && Minecraft.getInstance().screen == null) {
            Minecraft.getInstance().setScreen(new JustScreen());
            Minecraft.getInstance().player.sendMessage(new StringTextComponent("Меню успешно открыто."), Minecraft.getInstance().player.getUUID());


        }
    }

    private void registerKeys() {
        ClientRegistry.registerKeyBinding(OPEN_EVENT_LIST);
    }
}
