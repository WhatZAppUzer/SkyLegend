package de.whatsappuser.skylegend.lib.command;

import java.util.List;

public interface ICommandManager<T> {

    public List<T> getCommands();

    public void createCommand(T t);

    public void registerCommand(T t, boolean value);

    public void unregisterCommand(T t);

    public T getCommand(T t);
}
