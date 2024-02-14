package Model.Player;

import Model.Team.Team;

import java.util.Objects;

/**
 * Desc: Class for player information
 */
public class Player {

    private String name;
    private int age;
    private Rating rating;
    private Type type;
    private Team team;
    private Role role;
    private Position position;

    /**
     * Constructor for Player when team isn't known
     * @param name Name of player
     * @param age Age of player
     * @param type Type of player
     * @param role Role of player
     * @param position Position of player
     */
    public Player(String name, int age, Type type, Role role, Position position){
        this.name = name;
        this.age = age;
        this.rating = new Rating(type);
        this.type = type;
        this.role = role;
        this.position = position;
    }

    


    /**
     * Getter for name
     * @return Player name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for age
     * @return Player age
     */
    public int getAge() {
        return age;
    }

    /**
     * Increase a player's age
     */
    public void increaseAge() {
        age = age + 1;
    }

    /**
     * Getter for rating
     * @return Player rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Getter for type
     * @return PlayerType
     */
    public Type getType() {
        return type;
    }

    /**
     * Equals method for player
     * @param o Player to be compared to
     * @return If player is the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age &&
                Objects.equals(name, player.name) &&
                Objects.equals(rating, player.rating) &&
                Objects.equals(role, player.role) &&
                Objects.equals(position, player.position) &&
                Objects.equals(team.getName(), player.team.getName()) &&
                type == player.type;
    }

    /**
     * Hash method for player
     * @return Hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, rating, type, role, position, team.getName());
    }

    /**
     * String method for player
     * @return String of player
     */
    @Override
    public String toString() {
        String team;
        if(this.team == null){
            team = "None";
        } else{
            team = this.team.getName();
        }
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", type=" + type +
                ", role=" + role +
                ", position=" + position +
                ", team=" + team +
                '}';
    }

    /**
     * Getter for player team
     * @return Team of player
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Setter for player team
     * @param team Team of player
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * Getter for player's role
     * @return Role of player
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter for player's role
     * @param role New role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Getter for player's position
     * @return Position of player
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter for player's position
     * @param position New position
     */
    public void setPosition(Position position) {
        this.position = position;
    }
}
