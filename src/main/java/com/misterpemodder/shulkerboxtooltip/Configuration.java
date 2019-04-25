package com.misterpemodder.shulkerboxtooltip;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import me.sargunvohra.mcmods.autoconfig1.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1.annotation.ConfigEntry;
import me.shedaniel.cloth.gui.entries.EnumListEntry.Translatable;

@Config(name = "shulkerboxtooltip")
@Config.Gui.Background("minecraft:textures/block/purpur_block.png")
public class Configuration implements ConfigData {
  @ConfigEntry.Category("main")
  @ConfigEntry.Gui.TransitiveObject
  public MainModule main = new MainModule();


  public static class MainModule implements ConfigData {
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean lockPreview = false;
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean swapModes = false;
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean enablePreview = true;
    @ConfigEntry.Gui.Tooltip(count = 4)
    public ShulkerBoxTooltipType tooltipType = ShulkerBoxTooltipType.MOD;
  }

  public static enum ShulkerBoxTooltipType implements Translatable {
    VANILLA, MOD, NONE;

    @Override
    public String getKey() {
      return "shulkerboxtooltip.tooltip_type." + name().toLowerCase();
    }
  }
}