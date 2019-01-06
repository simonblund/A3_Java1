package game;
import utility.WelcomeMessage;

import java.awt.*;
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
        WelcomeMessage.welcomePlayer();
        
        while(running){


            System.out.println();

            System.out.print("Your coordinates: "+x+" : "+y); //prints the player's current location.
            System.out.println();

            Map.setVisited(x,y);

            if(Map.getLocationDescription(x,y)!=null){
                System.out.print(Map.getLocationDescription(x, y)); // If the room has a description
            }


            if(Map.getRoomMonster(x,y)==null){
                System.out.println("Phew, no monsters in this room.");
            } else{
                Fight.meetMonster(Map.getRoomMonster(x,y), player, x, y);
            }

            if(Map.foundSalesman(x,y)){
                Shop.encounterSalesman(player);
            }


            System.out.println("Where do you want to go? (north, south, east or west). Press m to show map.");
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
                case("m"):
                    Map.map(x,y);
            }

        }
    }//EOM play
    public static void playerDead(Player player){
        System.out.println(utility.Artwork.devil());
        System.out.println("Awwh, you died " + player.getName()+", better luck next time!");

        System.exit(0);
    }

    public static void lootTheRoom(int x, int y, Player player){
        Treasure treasure = Map.getTreasure(x,y);
        System.out.println();
        System.out.println("You peek behind the dead monster and see something...");
        if(treasure.getCoin()==0){
            System.out.println("Ooh a bottle of something, what does it say?");
            System.out.println(treasure.getName());
            System.out.println("That sounds interesting.");
            System.out.println(treasure.getName());
            System.out.println("You drink the potion and suddenly you feel healthier, health increases with " + treasure.getHealth());
            int health = player.getHealth()+treasure.getHealth();
            player.setHealth(health);
        } else {
            System.out.println("Ooh "+ treasure.getCoin()+" coins!");
            System.out.println("");
            int coins = player.getGold() + treasure.getCoin();
            player.setGold(coins);
        }


    }

}
