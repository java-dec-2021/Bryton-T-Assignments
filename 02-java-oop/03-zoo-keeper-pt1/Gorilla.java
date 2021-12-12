public class Gorilla extends Mammal {
    public Gorilla() {
        super();
    }
    public void throwSomething() {
        this.energyLevel -= 5;
        System.out.println("The gorilla has thrown something.");
        this.displayEnergy();
    }
    public void eatBannanas() {
        this.energyLevel += 10;
        System.out.println("The gorilla enjoyed a bananna.");
        this.displayEnergy();
    }
    public void climb() {
        this.energyLevel -= 10;
        System.out.println("The gorilla has climbed a tree.");
        this.displayEnergy();
    }
}
