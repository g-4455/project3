import java.util.ArrayList;

public class App{

    private static Boolean isPaid = true;
    private static int account = 0;
    private static int todaysfee = 0;
    private static int sellme = -10;
    private static Boolean continueloop = true;

    public static void updateaccount(int addme){account += addme;}
    public static void tax(){
        if (account >= todaysfee){
            account -= todaysfee;
            System.out.println("You had enough to pay today!");
            //Offical end of a day
        }else{
            isPaid = false;
        }
    }
    public static int acc(){return account;}
    
    public static ArrayList<Animal> dex = new ArrayList<Animal>();  
    
    //Days need to consist of:
    /* Tell player about a maitnence cost
     * Have the player sell animals
     * Reproducition Step 
     * Pay fee or game over
     */
    public static void main(String[] args) {
        //Run Intro
        Gameplay.intro();

        //Main Gameplay Loop
        while (isPaid){


            //Some new animals have arrived!
            Gameplay.seperator();
            System.out.println("You currently have: $" + account);
            todaysfee = Fee.getupdatedfee(); 

            //Reproduction function
            System.out.println("Some animals have reproduced!");
            Gameplay.reproductionloop();

            Gameplay.seperator();

            System.out.println("You need $" + todaysfee + " to complete the day (" + account + "/" + todaysfee+")");
            System.out.println("Select some animals to sell! (0 to stop)");

            //Selling function
            while (continueloop){
                sellme = Gameplay.sellchoice()-1;
                
                if (sellme < 0) continueloop = false; //If done selling
                else Animal.die(sellme);
                //Otherwise
            }
            continueloop = true;

            System.out.println("Finished Selling");

            //Check to see if game over or not
            Fee.incrementday();
            tax();

        }

        System.out.println("Game over! You survived for: " + Fee.getdays() + " days");
    }
}
