import java.util.Scanner;
import java.util.Random;

public class Gameplay extends Animal{

    public Gameplay(){super(s, s, parent1);} //Required code?

    private static String s = "~~~~~~~~~~~~~~~~~~ Day: "+ Fee.getdays() +" ~~~~~~~~~~~~~~~~~~";
    
    public static void seperator(){System.out.println(s);}

    private static Scanner read = new Scanner(System.in);

    private static Random coin = new Random();

    private static int rcount = 0; 

    private static int parent1 = -1;
    private static int parent2 = -2;

    private static int getinput(){
        int returnme = read.nextInt();
        //read.close(); This causes too many errors...
        return returnme;
    }
    
    public Animal choice(){
        //Reveal 3 random animals and let the user add 1 to the array
        System.out.println("Pick an animal with 1, 2, or 3");
        Animal[] op = {getrandom(), getrandom(), getrandom()};

        System.out.print("1. "); op[0].print();
        System.out.print("2. "); op[1].print();
        System.out.print("3. "); op[2].print();

        //How do I delete the other two? 
        int pick = -1;
        while (true) {
            pick = getinput(); 
            if (pick == 1 || pick == 2 || pick == 3) break;
            System.out.println("Wrong Input");
        }
        
        return op[pick-1];
    }

    public static int sellchoice(){
        Boolean continueloop = true;
        int returnme = -1;
        while (continueloop) {
            returnme = getinput(); 
            if (returnme >= 0 && returnme <= App.dex.size()) continueloop = false;
            //System.out.println("Erm... Wrong Input");
        }
        return returnme;
    }

    public void intro(){ //Loop the above functions 5 times
        for (int i = 0; i < 5; i++){App.dex.add(choice());}
        Function.update();
    }



    public void reproductionloop(){
        //max reproductions should be HALF of dex's size, rounded down
        int loops = (int) Math.floor(App.dex.size()/2);

        for (int l = 0; l < loops; l++){
            if (coin.nextInt(3) <= 2){ //Returns between 0 and 1 so reproduction is chance based
                parent1 = coin.nextInt(App.dex.size());
                parent2 = coin.nextInt(App.dex.size());
                System.out.println(App.dex.size());                

                //Reproduce if different parents are found
                Animal temp = App.dex.get(parent1);
                Animal temp2 = App.dex.get(parent2);

                if (temp != temp2){
                App.dex.add(reproduce(temp, temp2));
                System.out.println(temp.name + " & " + temp2.name + " gave birth to " + App.dex.get(App.dex.size()-1).name);
                rcount++;

                }
            }
        }

        //Reset parameters
        System.out.println(rcount + " animals reproduced today!");
        parent1 = -100;
        parent2 = -200;
        rcount = 0;
        Function.update();

    }
}
