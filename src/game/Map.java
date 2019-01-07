package game;

/**
 * Keeps track of things related to location.
 */
public class Map {
    // Simon
    private static int x = 6;
    private static int y = 6;

    private static Room[][] location = new Room[x][y]; //for now, tha map is a 6x6 grid. We could expand it.

    public static void roomToMap(int x, int y, Room room){
        if(location[x][y] == null){
            location[x][y] = room;
        }


    }
    static String getLocationDescription(int x, int y){
        return location[x][y].getDescription();
    }

    static Monster getRoomMonster(int x, int y){
        return location[x][y].getMonster();
    }

    public static void setRoomMonster(int x, int y, Monster monster){location[x][y].setMonster(monster);}

    static void setVisited(int x, int y){location[x][y].setVisited(true);}

    static Treasure getTreasure(int x, int y){return location[x][y].getTreasure();}

    static boolean foundSalesman(int x, int y){
        return location[x][y].isSalesman();
    }

    static void map(int a, int b){
        for(int i = y-1; i >=0; i--){
            String visitinrow = "";

            for(int j=0; j<x; j++){

                if(location[j][i].isVisited()){
                    if(i==b & j==a){
                        visitinrow+=("X ");
                    } else{
                        visitinrow+=("* ");
                    }
                }

                else {
                    visitinrow+=("O ");
                }
            }
            System.out.println(visitinrow);
        }
    }

    
}
