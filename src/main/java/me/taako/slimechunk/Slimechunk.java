package me.taako.slimechunk;

import java.util.Objects;
import me.taako.slimechunk.commands.SlimeChunkCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Slimechunk extends JavaPlugin {
    public FileConfiguration config = getConfig();

    public static final Component prefix =
            Component.text("[")
                    .color(NamedTextColor.DARK_GREEN)
                    .append(Component.text("Slime Chunk")
                            .color(NamedTextColor.GREEN)
                            .append(Component.text("]")
                                    .color(NamedTextColor.DARK_GREEN)
                                    .appendSpace()));

    @Override
    public void onEnable() {
        config.options().copyDefaults(true);
        saveDefaultConfig();

        Objects.requireNonNull(getCommand("slimechunk"))
                .setExecutor(new SlimeChunkCommand(config.getString("message-in-chunk"),
                        config.getString("message-not-in-chunk")));
    }
}
