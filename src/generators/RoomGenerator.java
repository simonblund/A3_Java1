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

    private static Room exampleRoom(){
        Room eroom = new Room();
        String des = "Ett exempelrum" + Math.random();
        eroom.setDescription(des);
        return eroom;
    }

    private static Room generatedRoom(){
        Room groom = new Room();
        int randomMonster = new Random().nextInt(monsters.size());
        boolean monsterPresent = (new Random().nextInt(10)<4); // 3 in 10 chance there is a monster in the room.
        boolean randomSalesman = (new Random().nextInt(8)==1); // 1 in 9 chance there is a salesman in the room.

        if(monsterPresent){
            groom.setMonster(monsters.get(randomMonster)); // Set a random monster to the room.
            monsters.remove(randomMonster); // remove the monster inserted from the list of available monsters.
        }



        groom.setSalesman(randomSalesman);
        return groom;
    }

    public static void placeExampleRooms(){
        for(int x = 0; x < 6; x++){
            for(int y = 0; y<6; y++){
                Map.roomToMap(x,y,generatedRoom());
            }
        }

    }
}
