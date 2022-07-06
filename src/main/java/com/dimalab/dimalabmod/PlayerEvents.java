package com.dimalab.dimalabmod;

import net.minecraftforge.event.TickEvent;


public class PlayerEvents {
    public static int ticksingame = 300;

    public static void clientTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            ticksingame -= 1;

        }
    }
}
