public class Bat extends Mammal {
    public Bat() {
        super();
        this.energyLevel = 300;
    }
    public void fly() {
        this.energyLevel -= 50;
        System.out.println("FLAP! FLAP! FLAP!");
        this.displayEnergy();
    }
    public void eatHuman() {
        this.energyLevel += 25;
        this.displayEnergy();
    }
    public void attackTown() {
        this.energyLevel -= 100;
        System.out.println("Alert! The city is under attack!");
        this.displayEnergy();
    }
}
