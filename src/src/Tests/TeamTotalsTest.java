package Tests;

import Model.Player.Player;
import Model.Player.Position;
import Model.Player.Role;
import Model.Player.Type;
import Model.Simulations.TeamTotals;
import Model.Team.Coach;
import Model.Team.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTotalsTest {

    @Test
    void TeamStats(){
        Player curry = new Player("Curry", 31, Type.Offensive_playmaker,
                Role.Star, Position.Point_guard);
        Player draymond = new Player("Draymond", 31, Type.Defensive_playmaker,
                Role.Star, Position.Power_forward);
        Player durant = new Player("Durant", 33, Type.Three_level_scorer,
                Role.Star, Position.Small_forward);
        Coach kerr = new Coach("Kerr", 50);
        Team warriors = new Team("Warriors", kerr);
        warriors.addPlayer(curry);
        warriors.addPlayer(draymond);
        warriors.addPlayer(durant);
        TeamTotals stats = new TeamTotals(warriors);
        assertTrue(stats.getInsideDefenseAverage() < 100);
    }

}