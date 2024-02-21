package Model.Games;

import Model.Simulations.GameSimulation;
import Model.Simulations.TeamStats;
import Model.Team.Team;

import java.util.Objects;

/**
 * Desc: Class for game information
 */
public class Game {

    private final Team team1;
    private final Team team2;
    private TeamStats team1BoxScore;
    private TeamStats team2BoxScore;
    private Team winner;
    private TeamStats winnerBoxScore;
    private Team loser;
    private TeamStats loserBoxScore;

    /**
     * Constructor for Game
     * @param team1 Team one
     * @param team2 Team two
     */
    public Game(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

    /**
     * Getter for team one
     * @return Team one
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * Getter for team two
     * @return Team two
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * Getter for team one box score
     * @return Team one score
     */
    public TeamStats getTeam1BoxScore() {
        return team1BoxScore;
    }

    /**
     * Setter for team one score
     * @param stats New box score
     */
    public void setTeam1BoxScore(TeamStats stats) {
        this.team1BoxScore = stats;
    }

    /**
     * Getter for team two score
     * @return stats Team two box score
     */
    public TeamStats getTeam2BoxScore() {
        return team2BoxScore;
    }

    /**
     * Setter for team two score
     * @param stats New box score
     */
    public void setTeam2BoxScore(TeamStats stats) {
        this.team2BoxScore = stats;
    }

    /**
     * Getter for winner
     * @return Winner of game
     */
    public Team getWinner() {
        return winner;
    }

    /**
     * Setter for winner
     * @param winner Winner of game
     */
    public void setWinner(Team winner) {
        this.winner = winner;
        winner.addWin();
        if(winner.equals(team1)){ //team2 loser
            winnerBoxScore = team1BoxScore;
            loserBoxScore = team2BoxScore;
            setLoser(team2);
        } else{ //team1 loser
            winnerBoxScore = team2BoxScore;
            loserBoxScore = team1BoxScore;
            setLoser(team1);
        }
    }

    /**
     * Getter for loser
     * @return Loser of game
     */
    public Team getLoser() {
        return loser;
    }

    /**
     * Setter for loser
     * @param loser Loser of game
     */
    public void setLoser(Team loser) {
        this.loser = loser;
        loser.addLoss();
    }

    

    /**
     * Hash method for game
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(team1, team2, team1BoxScore, team2BoxScore, winner, loser);
    }

    /**
     * To string method of game
     * @return String of game
     */
    @Override
    public String toString() {
        return "Game{" +
                "team1=" + team1.getName() +
                ", team2=" + team2.getName() +
                ", team1Score=" + team1BoxScore.getScore() +
                ", team2Score=" + team2BoxScore.getScore() +
                ", winner=" + winner.getName() +
                ", loser=" + loser.getName() +
                '}';
    }

    /**
     * Simulates a game
     */
    public void play(){
        GameSimulation simulation = new GameSimulation(this);
        simulation.runSimulation();
    }

    /**
     * Prints only the header of a game
     */
    public void printHeader(){
        String header = "|\n" +
                String.format("| %s versus %s\n", team1.getName(), team2.getName()) +
                String.format("| Winner: %s (%d - %d)\n", winner.getName(),
                        winnerBoxScore.getScore(), loserBoxScore.getScore()) +
                "|\n";
        System.out.println(header);
    }

    /**
     * Prints the total game, including box scores from both teams
     */
    public void printTotalResults(){
        printHeader();
        System.out.println(winnerBoxScore.toString());
        System.out.println(loserBoxScore.toString());

    }
}
