package test;

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
        monster.setName(sc.next());

        System.out.println("monster description:");
        monster.setDescription(sc.next());

        System.out.println("monster health (1-100):");
        monster.setHealth(sc.nextInt());

        System.out.println("monster strength(1-100):");
        monster.setStrength(sc.nextInt());

        Monsters.addMonster(monster);

        System.out.println("Saved. \n create another one? enter (1) or just enter to return.");

        if(sc.nextInt()==1){
            monsterForm();
        }
        Game.gameMenu();
    }
    public static void monstersInList(){
        List<Monster> monsters = Monsters.getMonsters();
        for(int i=0;i<monsters.size();i++){
            System.out.println(monsters.get(i).getName());
        }
    }
}
