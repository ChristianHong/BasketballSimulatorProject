package Model.Games;

import Model.Player.Player;
import Model.Team.Team;

import java.util.*;

/**
 * Desc: Class for league information
 */
public class League {

    private ArrayList<Team> teamList;
    private ArrayList<Season> seasonList;
    private int year;

    /**
     * Constructor for League
     * @param teamList List of teams in this league
     */
    public League(ArrayList<Team> teamList){
        this.teamList = teamList;
        this.seasonList = new ArrayList<>();
        this.year = Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Simulates a new season and adds it to seasonlist
     */
    public void simulateNewSeason(){
        Season season = new Season(this.teamList, this.year);
        season.simulateSeason();
        season.simulatePlayoffs();
        this.seasonList.add(season);
    }

    /**
     * Builds a map of all the games userTeam has played
     * @param userTeam Team that the user is monitoring
     * @return Map of all games userTeam has played (key = game number, value = game)
     */
    public HashMap<Integer, Game> buildMap(Team userTeam){
        int count = 0;
        HashMap<Integer, Game> gameMap = new HashMap<>();
        Season season = seasonList.get(0);
        for(Game game : season.getGameList()){
            if(game.getTeam1().getName().equals(userTeam.getName()) ||
                    game.getTeam2().getName().equals(userTeam.getName())){
                count += 1;
                gameMap.put(count, game);
                System.out.printf("Game %s (%s Season)%n", count, this.year);
                game.printHeader();
            }
        }
        for(Game game : season.getPlayoffs().getGameList()){
            if(game.getTeam1().getName().equals(userTeam.getName()) ||
                    game.getTeam2().getName().equals(userTeam.getName())){
                count += 1;
                gameMap.put(count, game);
                System.out.printf("Game %s (%s Playoffs)%n", count, this.year);
                game.printHeader();
            }
        }
        return gameMap;
    }

    
}
