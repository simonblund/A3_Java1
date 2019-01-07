package generators;

import game.*;
import repository.Monsters;
import repository.TreasureRepository;

import java.util.List;
import java.util.Random;

/**
 * Generates rooms and adds the Room array.
 */

public class RoomGenerator {
    // Simon

    private static Monsters unusedGameMonsters = Game.gameMonsters;
    private static List<Monster> monsters = unusedGameMonsters.getMonsters();

    private static Room generatedRoom(){
        Room groom = new Room();
        int randomMonster = new Random().nextInt(monsters.size());
        int randomTreasure = new Random().nextInt(TreasureRepository.treasures.size());
        boolean monsterPresent = (new Random().nextInt(5)==1); // 1 in 5 chance there is a monster in the room.
        boolean randomSalesman = (new Random().nextInt(10)==1); // 1 in 10 chance there is a salesman in the room.


        Treasure treasure = TreasureRepository.treasures.get(randomTreasure);

        if(monsterPresent){
            groom.setMonster(monsters.get(randomMonster)); // Set a random monster to the room.
            monsters.remove(randomMonster); // remove the monster inserted from the list of available monsters.
            groom.setTreasure(treasure);
            TreasureRepository.treasures.remove(treasure);
        }

        groom.setSalesman(randomSalesman);
        return groom;
    }

    private static void placeBoss(){
        Monster boss = MonsterMaker.generateBoss();
        int i = new Random().nextInt(6);
        int j = new Random().nextInt(6);
        Map.setRoomMonster(i,j,boss);

    }

    public static void placeExampleRooms(){
        TreasureRepository.generateTreasures();
        for(int x = 0; x < 6; x++){
            for(int y = 0; y<6; y++){
                Map.roomToMap(x,y,generatedRoom());
            }
        }
        placeBoss();

    }
}
