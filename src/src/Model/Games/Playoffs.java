package Model.Games;

import Model.Team.Team;

import java.util.ArrayList;

/**
 * Desc: Class for Playoff information
 */
public class Playoffs {

    private final int year;
    private Team champion;
    private PlayoffRound championshipRound;
    private ArrayList<Game> gameList;
    private Team bucks;
    private Team warriors;
    private Team nuggets;
    private Team celtics;

    /**
     * Constructor for Playoffs
     * @param teams Teams in playoffs
     * @param year Year of playoffs
     */
    public Playoffs(ArrayList<Team> teams, int year){
        this.year = year;
        this.gameList = new ArrayList<>();
        for(Team team : teams){
            switch (team.getName()) {
                case "Bucks":
                    bucks = team;
                    break;
                case "Warriors":
                    warriors = team;
                    break;
                case "Nuggets":
                    nuggets = team;
                    break;
                default:  //must be celtics
                    celtics = team;
                    break;
            }
        }
    }

    

    /**
     * Simulates the playoffs
     */
    public void simulate(){
        PlayoffRound westRound = simulateRound(nuggets, warriors, RoundType.West);
        PlayoffRound eastRound = simulateRound(bucks, celtics, RoundType.East);
        PlayoffRound championshipRound = simulateRound(westRound.getWinner(), eastRound.getWinner(),
                RoundType.Championship);
        championshipRound.getWinner().addChampionship();
        this.champion = championshipRound.getWinner();
        this.championshipRound = championshipRound;
        System.out.printf("| The %s have won the %s championship!%n",
                championshipRound.getWinner().getName(), year);
        System.out.println(championshipRound.getWinner().toString());
    }

    /**
     * Getter for playoff year
     * @return Year of playoffs
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter for championship
     * @return Team that won the championship
     */
    public Team getChampion() {
        return champion;
    }

    /**
     * Getter for championshipRound
     * @return Final round information
     */
    public PlayoffRound getChampionshipRound() {
        return championshipRound;
    }

    /**
     * Getter for games list
     * @return List of games during playoffs
     */
    public ArrayList<Game> getGameList() {
        return gameList;
    }
}