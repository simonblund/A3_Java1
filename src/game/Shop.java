package game;

import java.util.Scanner;

public class Shop {
    public static void encounterSalesman(Player player){
        System.out.println("You come across a salesman. Type 1 to look at the items for sale. Type any other NUMBER-key to leave.");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1){
            browseMerchantsItems(player);
        }
        else {
            System.out.println("You leave without buying anything. Perhaps you will meet the salesman again.");
        }
    }

    public static void browseMerchantsItems(Player player){
        boolean browse = true;

        while (browse){

            System.out.println("1. Buy a health potion for 50 coin.");
            System.out.println("2. Leave.");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice){

                case (1):

                    if (player.getGold() >= 50){
                        player.setGold(player.getGold()-50);
                        player.setHealthPotions(player.getHealthPotions() +1);
                        System.out.println("You bought a healt potion. You now have" + player.getHealthPotions() + " healt potions in your inventory.");
                    }
                    else {System.out.println("You dont have enough coin.");}
                    break;

                case (2):
                    System.out.println("You say goodbye to the salesman. Perhaps you will meet again.");
                    browse = false;
                    break;

                default:
                    break;
            }

        }

    }//EOXbrowseMerchantsitems
}
