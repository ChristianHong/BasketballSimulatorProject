package Tests;

import Model.Generator.GenerateTeam;
import Model.Games.Playoffs;
import Model.Team.Team;
import Model.Team.TeamType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayoffsTest {
    private Playoffs playoffs;
    private GenerateTeam generator;
    @BeforeEach
    void setUp() {
        generator = new GenerateTeam();
        ArrayList<Team> teamList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Team team = generator.createTeam();
            teamList.add(team);
        }
        playoffs = new Playoffs(teamList, 2020);
    }

    @Test
    void simulateRound() {
        playoffs.simulate();
    }
}
