package de.whatsappuser.skylegend.lib.player;

import java.util.List;
import java.util.UUID;

public interface IPlayerManager {

    public List<ISkyPlayer> getSkyPlayers();

    public ISkyPlayer getSkyPlayer(UUID uniqueId);

    public ISkyPlayer getSkyPlayer(String name);

    public ISkyPlayer loadPlayer(UUID uniqueId);

    public ISkyPlayer loadPlayer(String name);

    public boolean savePlayer(UUID uniqueId);

    public boolean savePlayer(String name);

    public boolean isPlayerExisting(UUID uniqueId);

    public boolean isPlayerExisting(String name);
}
