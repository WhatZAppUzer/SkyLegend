package de.whatsappuser.skylegend.commands.admin;

import de.whatsappuser.skylegend.commands.SubCommand;
import org.bukkit.command.CommandSender;

import java.util.Collections;

public class ReloadCommand extends SubCommand {

    public ReloadCommand() {
        super("reload", "reload the Plugin and the configurations", "skylegend.reload", false, Collections.singletonList("rl"));
    }

    @Override
    protected void execute(CommandSender sender, String[] args) {

    }
}
