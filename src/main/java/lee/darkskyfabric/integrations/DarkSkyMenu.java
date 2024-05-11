package lee.darkskyfabric.integrations;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.terraformersmc.modmenu.api.UpdateChecker;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DarkSkyMenu implements ModMenuApi {

    private static final Identifier BACKGROUND_TEXTURE = new Identifier("minecraft", "textures/gui/advancements/backgrounds/stone.png");

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            return new Screen(Text.of("The Dark Sky Mod Config")) {
                @Override
                protected void init() {
                    super.init();
                    final CustomButtonWidget escapebutton = new CustomButtonWidget(width/ 2 - 100, height / 2, 50, 20, Text.of("Exit"), (btn) -> {
                        btn.setMessage(Text.of("Exit"));
                        this.close();
                    });
                    final CustomButtonWidget button = new CustomButtonWidget(width / 2 - 100, height / 2 - 24, 200, 20, Text.of("Eternal Darkness: " + (Config.disable ? "Yes" : "No")), (btn) -> {
                        Config.disable = !Config.disable;
                        btn.setMessage(Text.of("Eternal Darkness: " + (Config.disable ? "Yes" : "No")));
                        Config.save();
                    });
                    addDrawableChild(button);
                    addDrawableChild(escapebutton);

                }
            };
        };
    }

    @Override
    public UpdateChecker getUpdateChecker() {
        return ModMenuApi.super.getUpdateChecker();
    }

    public static class CustomButtonWidget extends ButtonWidget {
        public CustomButtonWidget(final int x, final int y, final int width, final int height, final Text message, final PressAction onPress) {
            super(x, y, width, height, message, onPress, button -> (MutableText)message);
        }
    }
}