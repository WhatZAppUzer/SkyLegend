package de.whatsappuser.skylegend.lib.player.statistics;

public interface IPlayerStatistics {

    public int getBreakBlocks();

    public int getPlaceBlocks();

    public int getCoins();

    public long getLastLogin();

    public long getFirstLogin();

    public int getIssuedCoins();

    public int getWarns();

    public int getBans();

    public int getKicks();

    public void delete();

    public void update();

    public void save();
}
