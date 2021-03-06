package com.misterpemodder.shulkerboxtooltip.impl.network.client;

import com.misterpemodder.shulkerboxtooltip.api.ShulkerBoxTooltipApi;
import com.misterpemodder.shulkerboxtooltip.impl.ShulkerBoxTooltip;
import com.misterpemodder.shulkerboxtooltip.impl.config.Configuration.EnderChestSyncType;
import com.misterpemodder.shulkerboxtooltip.impl.network.server.S2CPacketTypes;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class C2SEnderChestUpdateRequestPacketType extends C2SPacketType<Void> {
  C2SEnderChestUpdateRequestPacketType(String id) {
    super(id);
  }

  @Override
  protected boolean readPacket(PacketContext context, PacketByteBuf buf) {
    ServerPlayerEntity player = (ServerPlayerEntity) context.getPlayer();

    if (ShulkerBoxTooltipApi.hasModAvailable(player)
        && ShulkerBoxTooltip.config.server.enderChestSyncType == EnderChestSyncType.PASSIVE) {
      context.getTaskQueue().execute(() -> S2CPacketTypes.ENDER_CHEST_UPDATE.sendToPlayer(player,
          player.getEnderChestInventory()));
    }
    return true;
  }
}
