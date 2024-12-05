
public class Test{
    public static void main(String[] args){
        /*     //Neanderthal testing = new Neanderthal();
        //System.out.println(testing.myname());

        Animal an1 = Animal.getrandom();
        Animal an2 = Animal.getrandom();
        Animal an3 = Animal.getrandom();
        Animal an4 = Animal.getrandom();

        an1.print();
        an2.print();
        an3.print();
        an4.print();

        //System.out.println(Function.mergeString(an1.name, an2.name));
        //System.out.println(Function.mergeString("test", "test"));

        Animal reptest = Animal.reproduce(an1, an2);
        reptest.print();

        Animal reptest2 = Animal.reproduce(an3, an4);
        reptest2.print();

        Animal superreptest = Animal.reproduce(reptest, reptest2);
        superreptest.print();

        //Function.add(Gameplay.choice());
       // Function.add(Gameplay.choice());
        //Function.add(Gameplay.choice());

        Function.update();

        //Function.add(Gameplay.choice());

        Function.update();
        */

        int day = 1;
        int fee = 0;
        int count = 0;

        while (count < 100){
            fee = day^2;
            day++;
            System.out.println(fee);
            count++;
        }
    }
}
