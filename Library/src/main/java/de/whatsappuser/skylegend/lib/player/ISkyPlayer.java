package de.whatsappuser.skylegend.lib.player;

import de.whatsappuser.skylegend.lib.island.IIsland;
import de.whatsappuser.skylegend.lib.player.statistics.IPlayerStatistics;

import java.util.List;

public interface ISkyPlayer {

    public String getName();

    public String getDisplayName();

    public void update();

    public void update(boolean value);

    public IPlayerStatistics getStatistics();

    public boolean deleteStatistics();

    public boolean saveStatistics();

    public List<IIsland> getIslands();

    public IIsland getIsland();

    public int getTopRank();
}
