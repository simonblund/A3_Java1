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

            //every time the player moves over the map, theres a 1/5 chance to encounter an enemy.
            //if(dice.nextInt(5) == 0){
            //    encounterEnemy();
            //}

            // Theres also a 1/10 chance to meet a salesman.
            //if(dice.nextInt(10) == 0){
           //     encounterSalesman();
           // }

            //... and 1/100 chance to encounter the final boss - a very big dragon.
            //else if(dice.nextInt(100) == 0){
            //    encounterDragonBoss();
            //}

            System.out.print(Map.getLocationDescription(x, y)); //Prints a description of the players current location.

            encounterEnemy(Map.getRoomMonster(x,y), player);
            System.out.println("");
            System.out.println("Where do you want to go? (north, south, east or west).");
            direction = input.nextLine();

            // this switch allows tha player to move over the map.
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

    public static void encounterEnemy(Monster monster, Player player){
        Random dice = new Random();
        System.out.println("Something moves in the dark...");
        System.out.println("You look closer, and suddenly you see a beast..");
        System.out.println("It is the "+monster.getName()+", and it wants to fight you.");
        System.out.println("You try and make up your mind whether you'll fight it or run away but can't make up your mind");
        System.out.println("You decide to use a dice to make the decision, if the dice shows 5 or 6 you'll run away.");

        int res = dice.nextInt(7);
        System.out.println("You roll the dice...");
        System.out.println(res);
        if(res < 5){
            System.out.println("You decide to fight the monster.");
            fightMonster(monster, player);
        }


    }

    public static void fightMonster(Monster monster, Player player){
        System.out.println("You hit the monster with all your strength.");
        while(player.getHealth()>0 && monster.getHealth()>0) {
            monster.setHealth(hit(player.getStrength(), monster.getHealth()));
            System.out.println("You have health "+player.getHealth());
            System.out.println("The monster has health "+monster.getHealth());
            player.setHealth(hit(monster.getStrength(), player.getHealth()));
            System.out.println("You have health "+player.getHealth());
            System.out.println("The monster has health "+monster.getHealth());
            System.out.println("");
        }
    }

    public static int hit(int strength, int health){
        int dice = new Random().nextInt(7);
        System.out.println("The dice is toss, it shows "+dice);
        if (dice >5){
            strength *= 2;
        }
        return health - strength;
    }

    public static void encounterSalesman(){
    }

    public static void encounterDragonBoss(){

    }
}
