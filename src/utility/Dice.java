package utility;

import java.util.Random;

public class Dice {
    public static int dice(){
        Random dice = new Random();
        return dice.nextInt(6)+1;
    }
}
