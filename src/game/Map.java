package game;

public class Map {
    public static String locale(int x, int y){
        Room[][] location = new Room[6][6];
        
        location[0][0] = new Room("a");
        location[0][1] = new Room("b");
        location[0][2] = new Room("c");
        location[0][3] = new Room("d");
        location[0][4] = new Room("e");
        location[0][5] = new Room("f");
        
        location[1][0] = new Room("g");
        location[1][1] = new Room("h");
        location[1][2] = new Room("j");
        location[1][3] = new Room("j");
        location[1][4] = new Room("k");
        location[1][5] = new Room("l");
        
        location[2][0] = new Room("m");
        location[2][1] = new Room("n");
        location[2][2] = new Room("o");
        location[2][3] = new Room("p");
        location[2][4] = new Room("r");
        location[2][5] = new Room("r");
        
        location[3][0] = new Room("s");
        location[3][1] = new Room("t");
        location[3][2] = new Room("u");
        location[3][3] = new Room("v");
        location[3][4] = new Room("w");
        location[3][5] = new Room("x");
        
        location[4][0] = new Room("y");
        location[4][1] = new Room("z");
        location[4][2] = new Room("au");
        location[4][3] = new Room("ae");
        location[4][4] = new Room("oe");
        location[4][5] = new Room("omega");
        
        location[5][0] = new Room("delta");
        location[5][1] = new Room("figaro");
        location[5][2] = new Room("maison");
        location[5][3] = new Room("le coq rouge");
        location[5][4] = new Room("filemon");
        location[5][5] = new Room("arthur");
        
        return location[x][y].getDescription();
    }
    
}
