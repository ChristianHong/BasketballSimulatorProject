package Tests;

import Model.Player.Player;
import Model.Player.Position;
import Model.Player.Role;
import Model.Player.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Lebron James", 35, Type.All_around,
                Role.Starter, Position.Small_forward);
    }

    @Test
    void getType() {
        assertEquals(Type.All_around, player.getType());
    }
    
    @Test
    void increaseAge() {
        player.increaseAge();
        assertEquals(36, player.getAge());
    }
}