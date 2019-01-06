package generators;

import game.Game;
import game.Map;
import game.Monster;
import game.Room;
import repository.Monsters;

import java.util.List;
import java.util.Random;

public class RoomGenerator {

    private static Monsters unusedGameMonsters = Game.gameMonsters;
    private static List<Monster> monsters = unusedGameMonsters.getMonsters();

    private static Room generatedRoom(){
        Room groom = new Room();
        int randomMonster = new Random().nextInt(monsters.size());
        boolean monsterPresent = (new Random().nextInt(5)==1); // 3 in 10 chance there is a monster in the room.
        boolean randomSalesman = (new Random().nextInt(10)==1); // 1 in 9 chance there is a salesman in the room.

        if(monsterPresent){
            groom.setMonster(monsters.get(randomMonster)); // Set a random monster to the room.
            monsters.remove(randomMonster); // remove the monster inserted from the list of available monsters.
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
        for(int x = 0; x < 6; x++){
            for(int y = 0; y<6; y++){
                Map.roomToMap(x,y,generatedRoom());
            }
        }
        placeBoss();

    }
}
