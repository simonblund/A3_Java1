package game;

import static game.Fight.hit;
import java.util.Scanner;

/**
 * Holds everything related to the salesman.
 */
public class Shop {
    // Daniel

    private static void encounterMessage() {
        System.out.println("You have come across a salesman... which is a bit strange... considering the surroundings. \n"
                + "Type 1 to look at the items for sale. Type 2 to talk to the salesman. Type 3 to leave.");
    }
    
    public static void encounterSalesman(Player player) {


        Scanner input = new Scanner(System.in);
        String choice;

        boolean running = true;
        
        while (running) {
            encounterMessage();
            choice = input.nextLine();
            
            switch (choice) {
                case ("1"):
                    browseMerchantsItems(player);
                    break;
                case ("2"):
                    talkToMerchant(player);
                    break;
                case ("3"):
                    running = false;
                    break;
                default:
                    break;
            }
        }
        
    } // end method encounterSalesman()

    private static void browseMerchantsItems(Player player) {
        boolean browse = true;
        
        System.out.println();
        System.out.println("The salesman is showing his wares. Mostly illegal drugs, off course. But there is also a few \n"
                + "items that may come in handy in your current situation. \n ");
        

        while (browse) {
            
            System.out.println("You have" +player.getGold()+ " coin.");
            System.out.println("1. Buy a health potion for 50 coin.");
            System.out.println("2. Buy weapon upgrade. for 30 coin.");
            System.out.println("3. Stop shopping.");

            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {

                case (1):

                    if (player.getGold() >= 50) {
                        player.setGold(player.getGold() - 50);
                        player.setHealth(player.getHealth()+100);
                        System.out.println("You bought a healt potion. You now have" + player.getHealth() + " health.");
                    } else {
                        System.out.println("You dont have enough coin.");
                    }
                    break;
                
                case (2):
                    if (player.getGold() >=30){
                        player.setGold(player.getGold()-30);
                        player.setStrength(player.getStrength() +30);
                        System.out.println("You bought a weapon upgrade. You now do " + player.getStrength() +" damage.");
                    } else {
                        System.out.println("You dont have enough coin.");
                    }
                    break;
                
                case (3):
                    System.out.println("Salesman: Thank you, come again!");
                    browse = false;
                    break;

                default:
                    break;
            }

        }

    }//EOXbrowseMerchantsitems

    private static void talkToMerchant(Player player) {
        Scanner input = new Scanner(System.in);
        String answer;
        
        System.out.println("You: Hey man, what are you doing here?");
        input.nextLine();
        System.out.println("Salesman: Me? Oh, nothin much... ");
        input.nextLine();
        System.out.println("You: Im trapped in here, do you know the way out?");
        input.nextLine();
        System.out.println("Salesman: Well of course! How else could i replentish my stock?");
        input.nextLine();
        System.out.println("You: Tell me then.");
        input.nextLine();
        System.out.println("Salesman: No.");
        input.nextLine();
        System.out.println("You: Why not?");
        input.nextLine();
        System.out.println("Salesman: Because there nothing in it for me. Besides, you are pretty much my only customer. \n"
                + "If you leave, i'll have to close my shop.");
        input.nextLine();
        System.out.println("You: But i may die in here!");
        input.nextLine();
        System.out.println("Salesman: Ok, ok. The exit is hidden behind that big, big monster over there. And you need the key... which i have. I'll sell it to you for ONE MILLION COINS.");
        input.nextLine();
        System.out.println("You realize now that you are dealing with a pure sociopath. Type 1 to do nothing. OR type 2 to kick his ass and steal the key.");
        answer = input.nextLine();
        
        boolean running = true;
        while (running){
            switch (answer){
                case ("1"):
                    running = false;
                    break;
                case ("2"):
                    
                    fightSalesman(player);
                    running = false;
                    break;
                default:
                    System.out.println("Type 1 to do nothing. OR type 2 to kick his ass and steal the key.");
                    answer = input.nextLine();
                    break;
                        
            }
        }
    }


    
    private static void fightSalesman(Player player){
        
        Monster salesman = new Monster();
        salesman.setHealth(500);
        salesman.setStrength(50);
        
        System.out.println("\n You take off your gloves and smack the salesmans face. The fight is on...\n\n");
        System.out.println();
        while(player.getHealth()>0 && salesman.getHealth()>0) {
            salesman.setHealth(hit(player.getStrength(), salesman.getHealth()));
            System.out.println("You have health "+player.getHealth());
            if(salesman.getHealth()<1){
                System.out.println("You won!");
                break;
            }
            System.out.println("The salesman has health "+salesman.getHealth());
            player.setHealth(hit(salesman.getStrength(), player.getHealth()));
            System.out.println("You have health "+player.getHealth());
            System.out.println("The salesman has health "+salesman.getHealth());
            System.out.println("");
        }
        if(player.getHealth()<1){
            System.out.println("You were knocked unconciuos. After a while, you wake up.\n");
            
            System.out.println("Salesman: As i said, you are my only customer. Thats why I let you live. Now buy some stuff or get lost!\n");
            player.setHealth(100);
            
        } else{
            System.out.println("You defeated the salesman! You steal the key, and shuffle some dirt on him to cover your tracks.\n");
            player.setKey(1);
        }
        
        
        
        
            
    
    }
}
