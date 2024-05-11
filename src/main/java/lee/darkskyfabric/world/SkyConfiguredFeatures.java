package lee.darkskyfabric.world;

import lee.darkskyfabric.DarkSkyFabric;
import lee.darkskyfabric.block.DarkSkyBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;


public enum SkyConfiguredFeatures {
    ;
    public static final RegistryKey<ConfiguredFeature<?, ?>> DARKORE_KEY = SkyConfiguredFeatures.registerKey("darkore");

    public static void boostrap(final Registerable<ConfiguredFeature<?, ?>> context) {
        final RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        final RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        final List<OreFeatureConfig.Target> overworldDarkOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, DarkSkyBlock.DARKORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, DarkSkyBlock.DARKORE.getDefaultState()));

        SkyConfiguredFeatures.register(context, SkyConfiguredFeatures.DARKORE_KEY, Feature.ORE, new OreFeatureConfig(overworldDarkOres, 8, 0.5f));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(final String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(DarkSkyFabric.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(final Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   final RegistryKey<ConfiguredFeature<?, ?>> key, final F feature, final FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
