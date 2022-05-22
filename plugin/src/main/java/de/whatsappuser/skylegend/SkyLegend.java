package de.whatsappuser.skylegend;

import de.whatsappuser.skylegend.commands.CommandManager;
import de.whatsappuser.skylegend.commands.admin.ReloadCommand;
import de.whatsappuser.skylegend.configuration.Config;
import de.whatsappuser.skylegend.configuration.Messages;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class SkyLegend extends JavaPlugin {

    private CommandManager commandManager;
    private Config skyConfig;
    private Messages messages;

    @Override
    public void onLoad() {
        this.commandManager = new CommandManager(this, "island");
        this.registerSubCommands();
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    //<editor-fold desc="registerSubCommands">
    private void registerSubCommands() {
        this.commandManager.registerCommand(new ReloadCommand(), true);
    }
    //</editor-fold>
}
