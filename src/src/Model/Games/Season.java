package Model.Games;

import Model.Player.Player;
import Model.Simulations.PlayerStats;
import Model.Team.Team;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Desc: Class for season information
 */
public class Season {

    private ArrayList<Game> gameList;
    private ArrayList<Team> teamList;
    private HashMap<Player, ArrayList<PlayerStats>> playerStatsMap;
    private SeasonLeader pointsLeader;
    private SeasonLeader reboundsLeader;
    private SeasonLeader assistsLeader;
    private SeasonLeader threeLeader;
    private Playoffs playoffs;
    private final int year;

    /**
     * Constructor for Season
     * @param teamList List of teams in this season
     * @param year Year of this season
     */
    public Season(ArrayList<Team> teamList, int year){
        this.gameList = new ArrayList<>();
        this.teamList = teamList;
        this.playerStatsMap = new HashMap<>();
        this.year = year;
    }

    /**
     * Line teams up against each other and add all games to gameList
     */
    public void arrangeGames(){
        for(Team team1 : this.teamList){ //loop through teams
            for(Team team2 : this.teamList){ //loop through teams to see who can play who
                if(!team1.equals(team2)){ //teams cant play each themselves
                    Game game = new Game(team1, team2); //teams will play each other twice
                    this.gameList.add(game);
                }
            }
        }
    }

    /**
     * Parse through gameList and play the games
     */
    public void playGames(){
        for(Game game : this.gameList){
            game.play();
        }
    }

    /**
     * Parse through played games and update season stats
     */
    public void parseGameStats(){
        for(Game game : this.gameList){
            for(PlayerStats stats : game.getTeam1BoxScore().getStatsList()){
                updateSeasonStats(stats);
            }
            for(PlayerStats stats : game.getTeam2BoxScore().getStatsList()){
                updateSeasonStats(stats);
            }
        }
    }

    /**
     * Enter data into playerStatsMap
     * @param stats Stats to be entered
     */
    public void updateSeasonStats(PlayerStats stats){
        if(this.playerStatsMap.containsKey(stats.getPlayer())){ //in map
            ArrayList<PlayerStats> statsList = this.playerStatsMap.get(stats.getPlayer());
            statsList.add(stats);
            this.playerStatsMap.put(stats.getPlayer(), statsList);
        } else{ //not in map yet
            List<PlayerStats> playerStats = new ArrayList<>();
            playerStats.add(stats);
            this.playerStatsMap.put(stats.getPlayer(), new ArrayList<>(playerStats));
        }
    }

    /**
     * Rounding method used to round doubles when calculating season averages
     * @param value Double to be rounded
     * @return Rounded double
     */
    public double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Parse through playerStatsMap to determine highest pts, rebs, and asts averages
     */
    public void parseSeasonStats(){
        HashMap<Player, Integer> pointsMap = new HashMap<>();
        HashMap<Player, Integer> reboundsMap = new HashMap<>();
        HashMap<Player, Integer> assistsMap = new HashMap<>();
        HashMap<Player, Integer> threeMap = new HashMap<>();
        for(ArrayList<PlayerStats> statsList : this.playerStatsMap.values()){ //loop through all stats
            for(PlayerStats stats : statsList){
                pointsMap = updatePlayerStats(pointsMap, stats.getTotalPoints(), stats.getPlayer());
                reboundsMap = updatePlayerStats(reboundsMap, stats.getRebounds(), stats.getPlayer());
                assistsMap = updatePlayerStats(assistsMap, stats.getAssists(), stats.getPlayer());
                threeMap = updatePlayerStats(threeMap, stats.getThreePointers(), stats.getPlayer());
            }
        }

        double highest = 0;
        for(Player player : pointsMap.keySet()){
            double avgPoints = (double) pointsMap.get(player) / (this.teamList.size()*3); //avg
            if(avgPoints > highest){
                highest = avgPoints;
                this.pointsLeader = new SeasonLeader(player, round(avgPoints), LeaderType.points);
            }
        }

        highest = 0;
        for(Player player : reboundsMap.keySet()){
            double avgRebs = (double) reboundsMap.get(player) / (this.teamList.size()*3); //avg
            if(avgRebs > highest){
                highest = avgRebs;
                this.reboundsLeader = new SeasonLeader(player, round(avgRebs), LeaderType.rebounds);
            }
        }

        highest = 0;
        for(Player player : assistsMap.keySet()){
            double avgAsts = (double) assistsMap.get(player) / (this.teamList.size()*3); //avg
            if(avgAsts > highest){
                highest = avgAsts;
                this.assistsLeader = new SeasonLeader(player, round(avgAsts), LeaderType.assists);
            }
        }

        highest = 0;
        for(Player player : threeMap.keySet()){
            int threes = threeMap.get(player);
            if(threes > highest){
                highest = threes;
                this.threeLeader = new SeasonLeader(player, threes, LeaderType.threes);
            }
        }
    }

    


    /**
     * Getter for games list
     * @return List of games during this season
     */
    public ArrayList<Game> getGameList() {
        return gameList;
    }

    /**
     * Getter for total player stats map
     * @return Map containing all player stats during season
     */
    public HashMap<Player, ArrayList<PlayerStats>> getPlayerStatsMap() {
        return playerStatsMap;
    }

    /**
     * Getter for highest points per game object
     * @return SeasonLeader containing player who averaged most points per game
     */
    public SeasonLeader getPointsLeader() {
        return pointsLeader;
    }

    /**
     * Getter for highest rebounds per game object
     * @return SeasonLeader containing player who averaged most rebounds per game
     */
    public SeasonLeader getReboundsLeader() {
        return reboundsLeader;
    }

    /**
     * Getter for highest assists per game object
     * @return SeasonLeader containing player who averaged most assists per game
     */
    public SeasonLeader getAssistsLeader() {
        return assistsLeader;
    }

    /**
     * Getter for most threes per season object
     * @return SeasonLeader containing player who scored most threes during the season
     */
    public SeasonLeader getThreeLeader() {
        return threeLeader;
    }

    /**
     * Getter for year of this season
     * @return Year
     */
    public int getYear() {
        return year;
    }

    /**
     * Getter for this seasons playoffs
     * @return Playoffs
     */
    public Playoffs getPlayoffs() {
        return playoffs;
    }

    /**
     * Prints out end season stats
     */
    public void endSeason(){
        Team lakers = null, warriors = null, celtics = null, sixers = null;
        for(Team team : teamList){
            switch (team.getName()){
                case "Lakers":
                    lakers = team;
                    break;
                case "Warriors":
                    warriors = team;
                    break;
                case "Celtics":
                    celtics = team;
                    break;
                case "Sixers":
                    sixers = team;
            }
        }
        String endString = "\n"+
                String.format("| %s Season results\n", this.year) +
                "|\n" +
                "| Records:\n" +
                String.format("| WEST: Lakers (%s-%s), Warriors (%s-%s)\n", lakers.getWins(), lakers.getLosses(),
                        warriors.getWins(), warriors.getLosses()) +
                String.format("| EAST: Sixers (%s-%s), Celtics (%s-%s)\n", sixers.getWins(), sixers.getLosses(),
                        celtics.getWins(), celtics.getLosses()) +
                "|\n" +
                "| Season leaders:\n" +
                "|\n" +
                this.pointsLeader.toString() +
                this.reboundsLeader.toString() +
                this.assistsLeader.toString() +
                this.threeLeader.toString();
        System.out.println(endString);
    }

    /**
     * Simulates this season
     */
    public void simulateSeason(){
        arrangeGames();
        playGames();
        parseGameStats();
        parseSeasonStats();
        endSeason();
    }

    /**
     * Simulates playoffs for this season
     */
    public void simulatePlayoffs(){
        this.playoffs = new Playoffs(this.teamList, this.year);
        playoffs.simulate();
    }


}
