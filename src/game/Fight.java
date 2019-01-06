package game;

import utility.Dice;
import java.util.Scanner;

public class Fight {
    public static void meetMonster(Monster monster, Player player, int x, int y){
        if (monster.isBoss() && monster.getHealth()>0){
            meetboss(monster, player);
        }else if (monster.getHealth()>0){
            System.out.println("");
            System.out.println("");
            System.out.println("Something moves in the dark...");
            System.out.println("You look closer, and suddenly you see a beast..");
            System.out.println("It is the "+monster.getName()+", and it looks angry.");
            System.out.println(monster.getName()+" has a health score of "+monster.getHealth()+" and a strength of "+monster.getStrength());

            System.out.println("Your stats are Health: "+player.getHealth()+" and strength "+player.getStrength());
            System.out.println("You try and make up your mind whether you'll fight it or run away but can't make up your mind, press ENTER to continue");
            Scanner click = new Scanner(System.in);
            click.nextLine();
            System.out.println("You decide to use a dice to make the decision, if the dice shows 5 or 6 you'll run away.");

            int res = utility.Dice.dice();
            System.out.println("You roll the dice...");
            System.out.println(res);
            if(res < 5){
                System.out.println("You decide to fight the monster.");
                fightMonster(monster, player, x, y);
            }
        }



    }

    public static void fightMonster(Monster monster, Player player, int x, int y){
        System.out.println();
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
            GamePlay.lootTheRoom(x,y, player);
        }

    }

    public static int hit(int strength, int health){
        int dice = Dice.dice();
        System.out.println("The dice is toss, it shows "+dice);
        if (dice >5){
            strength *= 2;
        }
        return health - strength;
    }

    public static void meetboss(Monster monster, Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.println(utility.Artwork.devil());
        System.out.println();
        System.out.println("Oh dear...");
        System.out.println("You seem to have found a way out... but...");
        System.out.println("It is guarded by the ugliest creature you have ever seen");
        System.out.println();
        System.out.println("It's " + monster.getName());
        System.out.println(monster.getDescription());
        System.out.println("It has health: " + monster.getHealth() + " and strength: " + monster.getStrength());
        System.out.println();
        System.out.println("You on the other hand have, health: " + player.getHealth() + " and strength: " + player.getStrength());
        System.out.println();
        System.out.println("The adrenaline rush you feel however makes you a lot quicker to run away \n so if you try to do that you have a 50 percent chance of succeeding with that.");
        System.out.println("What would you like to do?");
        System.out.println("1. Fight the beast. \n 2. Run away screaming");
        String choice = sc.nextLine();
        boolean running = true;
        while (running) {
            switch (choice) {
                case ("1"):
                    fightboss(monster, player);
                    running = false;
                    break;
                case ("2"):
                    System.out.println();
                    System.out.println("You try and run away, if the dice hits 4 or above you succeed.");
                    int dice = utility.Dice.dice();
                    System.out.println("You throw the dice...");
                    System.out.println(dice);
                    if(dice >3){
                        System.out.println("You ran away");
                    } else {
                        System.out.println("Awwh... it catched you");
                        fightboss(monster, player);
                    }
            }
        }
    }
    public static void fightboss(Monster monster, Player player){
        System.out.println("You get ready for the fight of the century");
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
            System.out.println("Congratulations");
        }
    }
}
