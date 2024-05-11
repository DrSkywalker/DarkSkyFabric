package lee.darkskyfabric.integrations;

import net.fabricmc.loader.api.FabricLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public enum Config {
    ;

    public static boolean disable = true;

    public static void load() {
        final File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "darksky.properties");
        if(!file.exists()) {
            return;
        }
        try {
            final BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
            final Properties prop = new Properties();
            prop.load(br);
            br.close();
            if(prop.get("enabled") instanceof final String val) {
                Config.disable = Boolean.parseBoolean(val);
            }

        }
        catch (final Exception e) {
            // Empty catch block
        }
    }

    public static void save() {
        final File file = new File(FabricLoader.getInstance().getConfigDir().toFile(), "darksky.properties");
        try {
            final FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8);
            writer.write("enabled " + Config.disable + "\n");
            writer.close();
        }
        catch (final Exception e) {
        }
    }

}
