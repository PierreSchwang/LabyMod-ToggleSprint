package de.pierreschwang.labymod.togglesprint.widgets;

import de.pierreschwang.labymod.togglesprint.Constants;
import net.labymod.api.client.gui.hud.HudWidget;
import net.labymod.api.client.gui.hud.annotation.HudWidgetTypeProvider;
import net.labymod.api.client.gui.hud.category.HudWidgetInformationCategory;
import net.labymod.api.client.gui.hud.config.HudWidgetConfig;
import net.labymod.api.client.gui.hud.info.HudWidgetInfo;
import net.labymod.api.client.gui.screen.widget.widgets.renderer.IconWidget;
import org.jetbrains.annotations.NotNull;

@HudWidgetTypeProvider(
    typeId = "state_indicator_sprint",
    categoryClass = HudWidgetInformationCategory.class
)
public class ToggleSprintInformationalWidget extends HudWidget<IconWidget, HudWidgetConfig> {

  public ToggleSprintInformationalWidget(@NotNull HudWidgetInfo info,
      @NotNull HudWidgetConfig config) {
    super(info, config, () -> {
      IconWidget icon = new IconWidget(Constants.SPRINT_TOGGLED);
      icon.bounds().setSize(20);
      return icon;
    });
    updateVisibility(false);
  }

}
