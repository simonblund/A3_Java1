package game;

import java.util.Random;
import utility.Artwork;

import java.util.Scanner;

public class Game {
    /*
    FIELDS / ATTRIBUTES
     */

    /*
    METHODS
     */
    public static void main(String[] args) {
        System.out.println(Artwork.gameName());
        gameMenu();
    }

    public static void gameMenu() {
        Scanner sc = new Scanner(System.in);
        boolean active = true;

        System.out.println("1. New Game");
        System.out.println("2. Scoreboard");
        System.out.println("3. Exit");

        while(active) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    newGame();
                    break;
                }
                case 2: {
                    scoreboard();
                    break;
                }
                case 3: {
                    System.exit(0);
                    break;
                }
                default: {
                    gameMenu();
                    break;
                }
            }
            active = false;
        }
    } // EOM gameMenu

    private static void newGame(){
        
        Scanner input = new Scanner(System.in);
        int x = 0; //x and y are used to navigate through the game. x corresponds to the maps x-axis, y to the maps y-axis.
        int y = 0;
        String direction; 
        Random dice = new Random();
        Boolean running = true; 
        
        while(running){
            
            //every time the player moves over the map, theres a 1/5 chance to encounter an enemy. Enemies drop gold and xp points. 
            if(dice.nextInt(5) == 0){
                encounterEnemy();
            }   
            
            // 1/10 chance to meet a salesman, who sells swords, armors, etc.. 
            else if(dice.nextInt(10) == 0){
                encounterSalesman();
            }
            
            //1/100 chance to encounter the final boss.
            else if(dice.nextInt(100) == 0){
                encounterDragonBoss();
            }
            
            System.out.print(Map.locale(x, y)); //Describes the players current location. 
            System.out.println("");
            System.out.println("Where do you want to go? (north, south, east or west).");
            direction = input.nextLine();
            
            // this switch allows tha player to move over the map. 
            switch(direction){
            
                case("north"): //perhaps its better to use WASD here?
                    y = y+1;
                    if (y>5){
                        System.out.println("You cant go further  north. Choose another path."); // the edges of the map are blocked off. 
                        y=y-1;
                    }
                    break; // after break occurs, the while-loop restarts. New chances to meet enemies, salesmen, or dragon boss. 
                case("east"): 
                    x = x+1;
                    if (x>5){
                        System.out.println("You cant go further east.");
                        x=x-1;
                    }
                    break;
                case("south"):
                    y = y-1;
                    if (y<0){
                        System.out.println("You can't go further south.");
                        y=y+1;
                    }
                    break;
                case("west"):
                    x = x-1;
                    if(x<0){
                        System.out.println("You can't go further west.");
                        x = x+1;
                    }
                    break;
                
            }
            
        }
    }
         
        public static void encounterEnemy(){
        }
    
        public static void encounterSalesman(){
        }
    
        public static void encounterDragonBoss(){
    
        }

    

    private static void scoreboard(){

    }
}
