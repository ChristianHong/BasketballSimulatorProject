package Model.Games;

import Model.Player.Player;

/**
 * Desc: Class for a season leader information
 */
public class SeasonLeader {

    /** Player who led a season type */
    private Player player;
    /** Number played averaged / had during a season */
    private double amount;
    /** Type that player led in */
    private LeaderType type;

    /**
     * Constructor for SeasonLeader
     * @param player Player who led a season type
     * @param amount Number player averaged / had
     * @param type Type that player led in
     */
    public SeasonLeader(Player player, double amount, LeaderType type){
        this.player = player;
        this.amount = amount;
        this.type = type;
    }

    /**
     * Getter for player
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Getter for amount
     * @return Amount
     */
    public double getAmount() {
        return amount;
    }

    
}