package de.pierreschwang.labymod.togglesprint;

import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;

@SuppressWarnings("FieldMayBeFinal")
@ConfigName("settings")
public class ToggleSprintConfiguration extends AddonConfig {

  @SwitchSetting
  private ConfigProperty<Boolean> enabled = new ConfigProperty<>(false);

  @SwitchSetting
  private ConfigProperty<Boolean> toggleSneak = new ConfigProperty<>(false);

  @SwitchSetting
  private ConfigProperty<Boolean> toggleSprint = new ConfigProperty<>(false);

  @SwitchSetting
  private ConfigProperty<Boolean> flyBoost = new ConfigProperty<>(false);

  @SliderSetting(min = 1, max = 10)
  private ConfigProperty<Float> flyBoostMultiplicity = new ConfigProperty<>(1f);

  @Override
  public ConfigProperty<Boolean> enabled() {
    return this.enabled;
  }

  public ConfigProperty<Boolean> toggleSneak() {
    return toggleSneak;
  }

  public ConfigProperty<Boolean> toggleSprint() {
    return toggleSprint;
  }

  public ConfigProperty<Boolean> flyBoost() {
    return flyBoost;
  }

  public ConfigProperty<Float> flyBoostMultiplicity() {
    return flyBoostMultiplicity;
  }

}