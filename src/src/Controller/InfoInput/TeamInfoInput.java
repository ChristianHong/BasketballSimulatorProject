package Controller.InfoInput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Class for setting all valid user inputs for creating a Team

public class TeamInfoInput {
    public static Set<String> bucksSet = new HashSet<>(Arrays.asList("bucks", "Bucks", "b", "B", "BUCKS"));
    public static Set<String> warriorsSet = new HashSet<>(Arrays.asList("warriors", "Warriors", "w", "W", "WARRIORS"));
    public static Set<String> celticsSet = new HashSet<>(Arrays.asList("celtics", "Celtics", "c", "C", "CELTICS"));
    public static Set<String> nuggetsSet = new HashSet<>(Arrays.asList("nuggets", "Nuggets", "n", "N", "NUGGETS"));
}
