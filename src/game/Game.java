package game;

import repository.MonsterXMLparse;
import repository.Monsters;
import generators.MonsterMaker;
import generators.RoomGenerator;
import utility.Artwork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class of the program.
 */

public class Game {
    /*
    FIELDS / ATTRIBUTES
     */
    public static Monsters gameMonsters = new Monsters(); // Simon

    /*
    METHODS
     */
    public static void main(String[] args) {
        // Simon
        System.out.println(Artwork.gameName());
        gameMonsters.setMonsters(new ArrayList<Monster>());
        gameMonsters = MonsterXMLparse.getMonsters();
        gameMenu();
    }

    public static void gameMenu() {
        // Simon
        Scanner sc = new Scanner(System.in);
        boolean active = true;

        System.out.println("1. New Game");
        System.out.println("2. Exit");
        System.out.println("3. Create your own monster");
        System.out.println("4. Save your monsters to File");

        while(active) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    newGame();
                    break;
                }
                case 2: {
                    System.exit(0);
                    break;
                }
                case 3: {
                    MonsterMaker.monsterForm();
                    break;
                }
                case 4: {
                    MonsterXMLparse.setMonsters(gameMonsters);
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
        // Simon
        Player player = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name below");
        player.setName(sc.nextLine());
        player.setHealth(100);
        player.setStrength(10);
        RoomGenerator.placeExampleRooms();
        GamePlay.play(player);
    }
}
