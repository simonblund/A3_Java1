package game;

import test.RoomGenerator;
import utility.Artwork;

import java.util.Scanner;

public class Game {
    /*
    FIELDS / ATTRIBUTES
     */
    public static String name;

    /*
    METHODS
     */
    public static void main(String[] args) {
        System.out.println(Artwork.gameName());
        RoomGenerator.placeExampleRooms();
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name below");
        name = sc.nextLine();
        GamePlay.play();
    }

    

    private static void scoreboard(){

    }
}
