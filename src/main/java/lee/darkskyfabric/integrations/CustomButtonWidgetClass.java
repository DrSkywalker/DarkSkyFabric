package lee.darkskyfabric.integrations;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class CustomButtonWidgetClass extends ButtonWidget {
    public CustomButtonWidgetClass(final int x, final int y, final int width, final int height, final Text message, final PressAction onPress) {
        super(x, y, width, height, message, onPress, button -> (MutableText)message);
    }
}