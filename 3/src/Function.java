import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//Static functions are stored here
public class Function {

    public static String getprint(Animal g){
        String returnme = App.dex.indexOf(g)+1 + ". " + g.name + " the " + g.type + " $" + g.price;
        return returnme;
    }

    //Get a randomized name
    public static String getfromfile(String path, int maxline){ //lib/Names.txt 50 and Lib/Species.txt 75
            //The herculian task of reading information from a single file
            try {
                FileReader input = new FileReader(path);
                BufferedReader reader = new BufferedReader(input);
                Random rand = new Random();
                int line = rand.nextInt(maxline); //Betweem lines 0 and 49 (I have it structured to automatically increment so the code will get line 1 in the 0 case)
                
                //Loop to stop at a random name
                for (int a = 0; a < line; a++) reader.readLine();
                String returnme = reader.readLine();
                reader.close();
                return returnme;
            } catch (IOException e) {e.printStackTrace();}

            return null;
    }

    public static int random(){
        Random rand = new Random();
        return rand.nextInt(50) + 50; //random number from 50 to 100
    }

    public static void update(){
        try (FileWriter path = new FileWriter("lib/Dex.txt")) {
            BufferedWriter output = new BufferedWriter(path);
            output.flush();

            for (int n = 0; n < App.dex.size(); n++) {
                output.write(getprint(App.dex.get(n)));
                output.newLine();
            }
            output.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    public static void die(int index) { 
        Animal temp = App.dex.get(index);
        App.dex.remove(index);
        App.updateaccount(temp.price);
        System.out.println("Goodbye " + temp.name);
        System.out.println("Account Balance: " + App.acc());
        Function.update();
    }

    //Merge two strings to create a randomized name
    public static String mergeString(String c, String d){
        if (c.equals(d)) return c + " Jr"; //Contingency for same name
        Random rand = new Random();

        String cAdd = c.substring(0, rand.nextInt(c.length()) + 1); //Get a substring from 0 to a random number
        String temp = d.toLowerCase();
        String dAdd = temp.substring(rand.nextInt(temp.length()), temp.length()); //Substring from randon number to end

        String returnme = cAdd + dAdd; 
        return returnme;
    }

    public static int compareInt(int f, int g){
        if (f > g || f == g) return f;
        if (g > f) return g; 
        
        System.out.println("Error in compareInt function line 43");
        return -1; //Error, should never be reacher
    }
}
