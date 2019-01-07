package repository;

import game.Treasure;
import generators.TreasureGenerator;

import java.util.ArrayList;

/**
 * Repository for treasures.
 */

public class TreasureRepository {
    // Simon
    public static ArrayList<Treasure> treasures = new ArrayList<>();


    public static void generateTreasures(){
        TreasureGenerator.newPotion("Aunt Olga's friday smoothie", "Just don't ask for the recipe.", 20);
        TreasureGenerator.newPotion("Father Goran's afternoon tea", "Smells like teen spirit", 25);

        TreasureGenerator.newCoin(5);
        TreasureGenerator.newCoin(5);
        TreasureGenerator.newCoin(5);
        TreasureGenerator.newCoin(5);
        TreasureGenerator.newCoin(5);
        TreasureGenerator.newCoin(5);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);
        TreasureGenerator.newCoin(10);

    }


}
