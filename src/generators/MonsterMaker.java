package generators;

import game.Game;
import game.Monster;
import repository.Monsters;

import java.util.List;
import java.util.Scanner;

public class MonsterMaker {
    public static void monsterForm(){
        Scanner sc = new Scanner(System.in);

        Monster monster = new Monster();

        System.out.println("monster name:");
        monster.setName(sc.nextLine());

        System.out.println("monster description:");
        monster.setDescription(sc.nextLine());

        System.out.println("monster health (1-100):");
        monster.setHealth(sc.nextInt());

        System.out.println("monster strength(1-100):");
        monster.setStrength(sc.nextInt());

        Game.gameMonsters.addMonster(monster);

        System.out.println("Saved. \n create another one? enter (1) OR go back to the main menu by entering 2.");

        if(sc.nextInt()==1){
            monsterForm();
        }
        Game.gameMenu();
    }
    public static void monstersInList(){

        if(!Game.gameMonsters.monstersEmpty()) {
            List<Monster> monsters = Game.gameMonsters.getMonsters();
            for (int i = 0; i < monsters.size(); i++) {
                System.out.println(monsters.get(i).getName());
            }
        }
    }

    public static Monster generateBoss(){
        Monster boss = new Monster();
        boss.setStrength(40);
        boss.setHealth(300);
        boss.setName("Janet in accounting");
        boss.setDescription("I'm the boss around here.");
        boss.setBoss(true);
        return boss;
    }
}
