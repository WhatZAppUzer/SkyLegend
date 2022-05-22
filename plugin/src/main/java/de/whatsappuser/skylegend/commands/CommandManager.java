package de.whatsappuser.skylegend.commands;

import de.whatsappuser.skylegend.SkyLegend;
import de.whatsappuser.skylegend.lib.command.ICommandManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandManager implements ICommandManager<SubCommand>, CommandExecutor{

    private final List<SubCommand> subCommands;
    private HashMap<String, SubCommand> subCommandList;
    private final SkyLegend legend;

    public CommandManager(SkyLegend legend, String command) {
        this.legend = legend;
        this.subCommands = new ArrayList<>();
        this.subCommandList = new HashMap<>();
        this.legend.getCommand(command).setExecutor(this);
    }

    @Override
    public List<SubCommand> getCommands() {
        return this.subCommands;
    }

    @Override
    public void createCommand(SubCommand subCommand) {
        for (String alias : subCommand.getAliases()) {
            this.subCommandList.put(alias, subCommand);
        }
        this.subCommands.add(subCommand);
    }

    @Override
    public void registerCommand(SubCommand subCommand, boolean value) {
        if (value) {
            for (String alias : subCommand.getAliases()) {
                if(!this.subCommandList.containsKey(alias)) {
                    this.subCommandList.put(alias, subCommand);
                }
                return;
            }
        } else {
            unregisterCommand(subCommand);
        }
    }

    @Override
    public void unregisterCommand(SubCommand subCommand) {
        for (String alias : subCommand.getAliases()) {
            this.subCommandList.remove(alias);
        }
        this.subCommands.remove(subCommand);
    }

    @Override
    public SubCommand getCommand(SubCommand subCommand) {
        for (String alias : subCommand.getAliases()) {
            if(this.subCommandList.containsKey(alias))
                return subCommand;
        }
        return null;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(args.length != 0) {
            if(this.subCommandList.containsKey(args[0])) {
                SubCommand command = this.subCommandList.get(args[0]);
                if(!command.isPlayer() || sender instanceof Player) {
                    if(sender.hasPermission(command.getPermission()) || command.getPermission().isEmpty()) {
                        command.execute(sender, args);
                        return true;
                    } else {
                        sender.sendMessage(this.legend.getSkyConfig().prefix + this.legend.getMessages().playerNoPermission);
                    }
                } else {
                    sender.sendMessage(this.legend.getSkyConfig().prefix + this.legend.getMessages().mustBeAPlayer);
                    return true;
                }
                return true;
            }
            return true;
        }
        sender.sendMessage(this.legend.getSkyConfig().prefix + this.legend.getMessages().commandHelp);
        for (SubCommand command : this.subCommands) {
            if(sender.hasPermission(command.getPermission())) {
                sender.sendMessage("§7§l- §b" + command.getName() + "§7/§b" + command.getAliases().get(0) + "§7: §e§l" + command.getDescription());
            } else {
                sender.sendMessage("§7§l- §b" + command.getName() + "§7/§b" + command.getAliases().get(0) + "§7: §e§l" + command.getDescription());
            }
        }
        return true;
    }
}
