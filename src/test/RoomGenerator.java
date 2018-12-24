package test;

import game.Map;
import game.Room;

public class RoomGenerator {

    private static Room exampleRoom(){
        Room eroom = new Room();
        String des = "Ett exempelrum" + Math.random();
        eroom.setDescription(des);
        return eroom;
    }

    public static void placeExampleRooms(){
        for(int x = 0; x < 6; x++){
            for(int y = 0; y<6; y++){
                Map.roomToMap(x,y,exampleRoom());
            }
        }

    }
}
