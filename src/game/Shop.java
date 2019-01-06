package game;

import java.util.Scanner;

public class Shop {
    public static void encounterSalesman(Player player){
        

            
            
            encounterMessage();
            
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            boolean running = true;
            while (running = true) {
                switch(choice){
                    case ("1"):
                        browseMerchantsItems(player);
                        encounterMessage();
                        choice = input.nextLine();
                        break;
                    case ("2"):
                        talkToMerchant();
                        encounterMessage();
                        choice = input.nextLine();
                        break;
                    case ("3"):
                        running = false;
                        break;
                    default:
                        choice = input.nextLine();
                        break;
                 }
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
    
    public static void talkToMerchant(){
     System.out.println("Hey, what are you doing here?");
    }
    
    public static void encounterMessage(){
        System.out.println("You come across a salesman... which is a bit strange considering the surroundings. \n"
                + "Type 1 to look at the items for sale. Type 2 to talk to the salesman. Type 3 to leave.");
        
    }
}
