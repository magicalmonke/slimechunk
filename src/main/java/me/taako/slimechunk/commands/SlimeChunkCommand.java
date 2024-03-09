package me.taako.slimechunk.commands;

import static me.taako.slimechunk.Slimechunk.prefix;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SlimeChunkCommand implements CommandExecutor {
    String messageInChunk;
    String messageNotInChunk;

    public SlimeChunkCommand(String messageInChunk, String messageNotInChunk) {
        this.messageInChunk = messageInChunk;
        this.messageNotInChunk = messageNotInChunk;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            boolean isSlimeChunk = ((Player) sender).getChunk().isSlimeChunk();
            Component returnMessage = prefix.append((isSlimeChunk)
                    ? LegacyComponentSerializer.legacyAmpersand().deserialize(
                    messageInChunk)
                    : LegacyComponentSerializer.legacyAmpersand().deserialize(
                    messageNotInChunk));

            sender.sendMessage(returnMessage);
        }

        return true;
    }
}
