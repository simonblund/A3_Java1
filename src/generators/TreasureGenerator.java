package generators;

import game.Treasure;
import repository.TreasureRepository;

public class TreasureGenerator {
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
