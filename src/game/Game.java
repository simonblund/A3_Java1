package game;

import repository.MonsterXMLparse;
import repository.Monsters;
import test.MonsterMaker;
import test.RoomGenerator;
import utility.Artwork;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    /*
    FIELDS / ATTRIBUTES
     */
    public static String name;
    public static Monsters gameMonsters = new Monsters();

    /*
    METHODS
     */
    public static void main(String[] args) {
        System.out.println(Artwork.gameName());
        gameMonsters.setMonsters(new ArrayList<Monster>());
        gameMonsters = MonsterXMLparse.getMonsters();
        RoomGenerator.placeExampleRooms();
        gameMenu();
    }

    public static void gameMenu() {
        Scanner sc = new Scanner(System.in);
        boolean active = true;


        MonsterMaker.monstersInList(); // TODO remove this line before turn in.

        System.out.println("1. New Game");
        System.out.println("2. Scoreboard");
        System.out.println("3. Exit");
        System.out.println("4. Create your own monster");
        System.out.println("5. Save your monsters to File");

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
                case 4: {
                    MonsterMaker.monsterForm();
                    break;
                }
                case 5: {
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name below");
        name = sc.nextLine();
        GamePlay.play();
    }

    

    private static void scoreboard(){

    }
}
