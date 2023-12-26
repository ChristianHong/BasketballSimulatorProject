package Controller.InfoInput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Class for setting all valid user inputs for creating a Player

public class PlayerInfoInput {
    public static Set<String> positionSet = new HashSet<>(Arrays.asList("Point_Guard", "Shooting_Guard", "Small_Forward", "Power_Forward", "Center"));
    public static Set<String> playerRoleSet = new HashSet<>(Arrays.asList("Superstar", "Star", "Starter", "Sixth-Man", "Bench"));
    public static Set<String> typeSet = new HashSet<>(Arrays.asList("Three_and_D", "All_around", "Offensive_playmaker",
            "Defensive_playmaker", "Playmaker", "Energetic_rebounder", "Three_level_scorer", "Post_player",
            "In_out_defender", "Pure_shooter", "Stretch_big", "Inside_defender", "Perimeter_defender", "Paint_beast",
            "Offensive_superstar", "Point_god", "Balanced_superstar", "Lockdown_defender", "Two_way_superstar", "God"));
}
