package InfoInput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Class for setting all valid user inputs for creating a Player

public class PlayerInfoInput {
    public static Set<String> positionSet = new HashSet<>(Arrays.asList("Point_Guard", "Shooting_Guard", "Small_Forward", "Power_Forward", "Center"));
    public static Set<String> playerRoleSet = new HashSet<>(Arrays.asList("Superstar", "Star", "Starter", "Sixth-Man", "Bench"));
    public static Set<String> playerTypeSet = new HashSet<>(Arrays.asList());
}
