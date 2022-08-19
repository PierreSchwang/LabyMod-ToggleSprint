package de.pierreschwang.labymod.togglesprint;

import com.google.inject.Singleton;
import de.pierreschwang.labymod.togglesprint.listener.GameTickListener;
import de.pierreschwang.labymod.togglesprint.listener.KeyPressListener;
import de.pierreschwang.labymod.togglesprint.listener.SettingUpdateListener;
import de.pierreschwang.labymod.togglesprint.widgets.ToggleSneakInformationalWidget;
import de.pierreschwang.labymod.togglesprint.widgets.ToggleSprintInformationalWidget;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonListener;

@Singleton
@AddonListener
public class ToggleSprintAddon extends LabyAddon<ToggleSprintConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(SettingUpdateListener.class);
    this.registerListener(KeyPressListener.class);
    this.registerListener(GameTickListener.class);
    this.labyAPI().hudWidgetService().registerWidgetType(ToggleSprintInformationalWidget.class);
    this.labyAPI().hudWidgetService().registerWidgetType(ToggleSneakInformationalWidget.class);
  }

  @Override
  protected Class<ToggleSprintConfiguration> configurationClass() {
    return ToggleSprintConfiguration.class;
  }

}