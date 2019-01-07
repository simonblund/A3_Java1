package generators;

import game.Treasure;
import repository.TreasureRepository;

/**
 * Generates treasures and adds them to the treasure array in the repository.
 */

public class TreasureGenerator {
    // Simon
    public static void newPotion(String name, String desc, int health){
        Treasure np = new Treasure();
        np.setName(name);
        np.setDescription(desc);
        np.setHealth(health);
        TreasureRepository.treasures.add(np);
    }
    public static void newCoin(int coin){
        Treasure nc = new Treasure();
        nc.setCoin(coin);
        TreasureRepository.treasures.add(nc);

    }
}
