package de.pierreschwang.labymod.togglesprint.state;

import de.pierreschwang.labymod.togglesprint.ToggleSprintConfiguration;
import net.labymod.api.Laby;
import net.labymod.api.client.gui.hud.HudWidget;
import net.labymod.api.event.labymod.config.SettingUpdateEvent;
import net.labymod.api.property.Property;
import org.jetbrains.annotations.Nullable;

public abstract class StateHolder<V> extends Property<V> {

  private final String widgetId;
  private final String configurationPath;

  public StateHolder(V baseValue, @Nullable String widgetId, String configurationPath) {
    super(baseValue);
    this.widgetId = widgetId;
    this.configurationPath = configurationPath;
  }

  public void updateWidgetVisibility(boolean visible) {
    if (widgetId() == null) {
      return;
    }
    for (HudWidget<?, ?> widget : Laby.labyAPI().hudWidgetService().getWidgets(widgetId())) {
      widget.updateVisibility(visible);
    }
  }

  public void callConfigurationUpdated(SettingUpdateEvent event) {
    if (!(event.setting().getAccessor() instanceof ToggleSprintConfiguration)) {
      return;
    }
    if (event.setting().getTranslationKey().equalsIgnoreCase(configurationPath())) {
      configurationValueUpdated(event.getValue());
    }
  }

  public abstract void configurationValueUpdated(V newValue);

  public String widgetId() {
    return widgetId;
  }

  public String configurationPath() {
    return configurationPath;
  }
}
