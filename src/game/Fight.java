package game;

import java.util.Random;
import java.util.Scanner;

public class Fight {
    public static void meetMonster(Monster monster, Player player){
        Random dice = new Random();
        if (monster.getHealth()>0){
            System.out.println("Something moves in the dark...");
            System.out.println("You look closer, and suddenly you see a beast..");
            System.out.println("It is the "+monster.getName()+", and it wants to fight you.");
            System.out.println("You try and make up your mind whether you'll fight it or run away but can't make up your mind, press ENTER to continue");
            Scanner click = new Scanner(System.in);
            click.nextLine();
            System.out.println("You decide to use a dice to make the decision, if the dice shows 5 or 6 you'll run away.");

            int res = dice.nextInt(7);
            System.out.println("You roll the dice...");
            System.out.println(res);
            if(res < 5){
                System.out.println("You decide to fight the monster.");
                fightMonster(monster, player);
            }
        }



    }

    public static void fightMonster(Monster monster, Player player){
        System.out.println("You hit the monster with all your strength.");
        while(player.getHealth()>0 && monster.getHealth()>0) {
            monster.setHealth(hit(player.getStrength(), monster.getHealth()));
            System.out.println("You have health "+player.getHealth());
            if(monster.getHealth()<1){
                System.out.println("You won!");
                break;
            }
            System.out.println("The monster has health "+monster.getHealth());
            player.setHealth(hit(monster.getStrength(), player.getHealth()));
            System.out.println("You have health "+player.getHealth());
            System.out.println("The monster has health "+monster.getHealth());
            System.out.println("");
        }
        if(player.getHealth()<1){
            GamePlay.playerDead(player);
        } else{
            GamePlay.lootTheRooom();
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
}
