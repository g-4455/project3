public abstract class Creature {
    // Source code is decompiled from a .class file using FernFlower decompiler.
   String name = "";
   String type = "";
   int generation = 0;
   int price = 0;
   int num = 0;

   //public abstract Animal Animal(String n, String t, int g);
   public abstract void die(int index);
   public abstract Animal randomize();
   public abstract Animal reproduce(Animal d, Animal e);
   //public abstract String getprint(Animal g);

   //print not listed as it is a debug function
    
}
