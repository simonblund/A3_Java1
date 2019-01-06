package game;

import java.util.Random;
import java.util.Scanner;

public class GamePlay {

    public static void play(Player player){

        Scanner input = new Scanner(System.in);
        int x = 0; //x and y are used to navigate through the game. x corresponds to the maps x-axis, y to the maps y-axis.
        int y = 0;
        String direction;
        Random dice = new Random();
        Boolean running = true;
        while(running){

            System.out.print("Your coordinates: "+x+" : "+y);

            if(Map.getLocationDescription(x,y)!=null){
                System.out.print(Map.getLocationDescription(x, y));
            }


            if(Map.getRoomMonster(x,y)==null){
                System.out.println("Phew, no monsters in this room.");
            } else{
                Fight.meetMonster(Map.getRoomMonster(x,y), player);
            }

            if(Map.foundSalesman(x,y)){
                Shop.encounterSalesman(player);
            }

            System.out.println("");
            System.out.println("Where do you want to go? (north, south, east or west).");
            direction = input.nextLine();

            // this switch allows the player to move over the map.
            switch(direction){

                case("north"):
                case("w"): // also allows player to use WASD to navigate. would be cool if player didnt have to press enter when making this input. but the enter press is probably for the sake of the console, not the java-program?
                    y = y+1;
                    if (y>5){ // these if-statements blocks the player from going outside the map.
                        System.out.println("You cant go further  north. Choose another path.");
                        y=y-1;
                    }
                    break; // after a break occurs, the program returns to the beginning of the while-loop. But since x and y have changed, the player is now in a new location.
                case("east"):
                case("d"):
                    x = x+1;
                    if (x>5){
                        System.out.println("You cant go further east.");
                        x=x-1;
                    }
                    break;
                case("south"):
                case("s"):
                    y = y-1;
                    if (y<0){
                        System.out.println("You can't go further south.");
                        y=0;
                    }
                    break;
                case("west"):
                case("a"):
                    x = x-1;
                    if(x<0){
                        System.out.println("You can't go further west.");
                        x = x+1;
                    }
                    break;

            }

        }
    }//EOM play
    public static void playerDead(Player player){
        System.out.println("Awwh, you died " + player.getName()+", better luck next time!");
    }

    public static void lootTheRoom(){

    }

}
