package de.whatsappuser.skylegend.commands;

import de.whatsappuser.skylegend.SkyLegend;
import de.whatsappuser.skylegend.configuration.Config;
import de.whatsappuser.skylegend.configuration.Messages;
import lombok.Getter;
import org.bukkit.command.CommandSender;

import java.util.List;

@Getter
public abstract class SubCommand {

    private final Config config;
    private final Messages messages;
    private final String name;
    private final String description;
    private final String permission;
    private final boolean player;
    private final List<String> aliases;

    public SubCommand(String name, String description, String permission, boolean player, List<String> aliases) {
        this.name = name;
        this.description = description;
        this.permission = permission;
        this.player = player;
        this.aliases = aliases;
        this.config = SkyLegend.getPlugin(SkyLegend.class).getSkyConfig();
        this.messages = SkyLegend.getPlugin(SkyLegend.class).getMessages();
    }

    protected abstract void execute(CommandSender sender, String[] args);
}
