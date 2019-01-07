package utility;

import java.util.Random;

/**
 * Utility to make sure dices are random and only show values between 1-6.
 */

public class Dice {
    // Simon
    public static int dice(){
        Random dice = new Random();
        return dice.nextInt(6)+1;
    }
}
