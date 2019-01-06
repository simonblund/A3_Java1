package game;

public class Map {

    private static Room[][] location = new Room[6][6]; //for now, tha map is a 6x6 grid. We could expand it.

    public static void roomToMap(int x, int y, Room room){
        if(location[x][y] == null){
            location[x][y] = room;
        }
        else System.out.println("Error: Map location not empty");
        // TODO remove the above line before turn-in.

    }
    public static String getLocationDescription(int x, int y){
        return location[x][y].getDescription();
    }

    public static Monster getRoomMonster(int x, int y){
        return location[x][y].getMonster();
    }

    public static boolean foundSalesman(int x, int y){
        return location[x][y].isSalesman();
    }

    
}
