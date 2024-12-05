public class Fee implements Market{

    //Encapsulation
    private static int fee = 0;
    private static int days = 1;
    private static int power = 2;
    private static int updatepower = 0;

    public static int getfee(){return fee;}

    public static int getdays(){return days;} //Unessecary but added just in case

    public static void incrementday(){
        days += 1;
        updatepower += 1;
        System.out.println("End of day " + days);
    }

    //public static void updatefee(){fee = (int) Math.pow(days, 2);} //Grows exponentially (never used)

    public static int getupdatedfee(){
        if (updatepower > 4) {
            power++; 
            updatepower = 0;
        } //increase the growth rate every 5 days
        
        fee = (int) Math.pow(days, power);
        return fee;
    }
}
