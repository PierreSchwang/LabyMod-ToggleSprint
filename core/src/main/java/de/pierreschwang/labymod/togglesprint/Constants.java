package de.pierreschwang.labymod.togglesprint;

import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;

public class Constants {

  public static final Icon SPRINT_TOGGLED = icon("sprint_toggled.png");
  public static final Icon SNEAK_TOGGLED = icon("sneak_toggled.png");
  public static final Icon FLY_BOOST = icon("enableflyboost.png");

  public static final String I18N_KEY_SETTING_ENABLED = "toggle-sprint.settings.enabled";
  public static final String I18N_KEY_SETTING_TOGGLE_SPRINT = "toggle-sprint.settings.toggleSprint";
  public static final String I18N_KEY_SETTING_TOGGLE_SNEAK = "toggle-sprint.settings.toggleSneak";
  public static final String I18N_KEY_SETTING_FLY_BOOST = "toggle-sprint.settings.flyBoost";

  private static Icon icon(String name) {
    return Icon.texture(ResourceLocation.create("toggle-sprint", "icons/" + name));
  }

}
