package game;

public class Map {
    private static int x = 6;
    private static int y = 6;

    private static Room[][] location = new Room[x][y]; //for now, tha map is a 6x6 grid. We could expand it.

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

    public static void setVisited(int x, int y){location[x][y].setVisited(true);}

    public static boolean foundSalesman(int x, int y){
        return location[x][y].isSalesman();
    }

    public static void map(){
        for(int i = y-1; i >=0; i--){
            String visitinrow = "";

            for(int j=0; j<x; j++){
                if(location[j][i].isVisited()){
                    visitinrow+=("X ");
                } else {
                    visitinrow+=("O ");
                }
            }
            System.out.println(visitinrow);
        }
    }

    
}
