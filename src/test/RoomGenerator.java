package test;

import game.Game;
import game.Map;
import game.Monster;
import game.Room;
import repository.Monsters;

import java.util.List;

public class RoomGenerator {

    private static Monsters unusedGameMonsters = Game.gameMonsters;

    private static Room exampleRoom(){
        Room eroom = new Room();
        String des = "Ett exempelrum" + Math.random();
        eroom.setDescription(des);
        return eroom;
    }

    private static Room generatedRoom(){
        Room groom = new Room();
        List<Monster> monsters = unusedGameMonsters.getMonsters();

        for (int i = 0; i<monsters.size(); i++){
            groom.setMonster(monsters.get(i));
            monsters.remove(i);
        }
        groom.setDescription("Generated with generatedRoom");
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
