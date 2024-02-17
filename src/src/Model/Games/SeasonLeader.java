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

    /**
     * Prints this season leader
     * @return String of season leader
     */
    @Override
    public String toString() {
        String top = "";
        String bottom = "|\n";
        if(this.type.equals(LeaderType.threes)){
            top = "| Leader in threes made during season\n";
            bottom = "";
        } else{
            top = String.format("| Leader in %s per game\n", this.type);
        }
        return  top + String.format("| %s (%s)- %s\n", this.player.getName(), player.getTeam().getName(),
                this.amount) + bottom;
    }
}