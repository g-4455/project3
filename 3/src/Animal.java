public class Animal extends Creature{
    //Data
    String name;
    String type;
    int generation;
    int price;
    int num;
    
    //Constructor
    public Animal(String n, String t, int g){
        this.name = n;
        this.type = t;
        this.generation = g;
        this.price = Function.random()*this.generation; 
        this.num = App.dex.size() + 1;
        //App.dex.add(this); Could automatically add them to array with this, but randomization in Gameplay 14 messes with it
    }

    public Animal randomize(){
            String tempname = Function.getfromfile("lib/Names.txt", 50);
            String temptype = Function.getfromfile("lib/Species.txt", 75);
            Animal returnme = new Animal(tempname, temptype, 1); //Gen should always be 1
    
            return returnme;
        }
    
    public Animal getrandom(){return randomize();}

    
    public void die(int index) { 
        Animal temp = App.dex.get(index);
        App.dex.remove(index);
        App.updateaccount(temp.price);
        System.out.println("Goodbye " + temp.name);
        System.out.println("Account Balance: " + App.acc());
        Function.update();
    }

    public Animal reproduce(Animal d, Animal e) {
        Animal returnme = new Animal(
            Function.mergeString(d.name, e.name),
            Function.mergeString(d.type, e.type),
            Function.compareInt(d.generation, e.generation) + 1
        );

        return returnme; 
    }

    public void print() {
        System.out.println(this.name + " the " + this.type + " $" + this.price);
    }
}
