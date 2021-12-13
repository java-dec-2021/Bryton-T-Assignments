public class Iphone extends Phone implements Ringable {
    public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        // your code here
        return "Your iPhone " + this.getVersionNumber() + " is ringing: " + this.getRingTone();
    }
    @Override
    public String unlock() {
        // your code here
        return "Your iPhone " + this.getVersionNumber() + " is now unlocked.";
    }
    @Override
    public void displayInfo() {
        // your code here
        System.out.println("iPhone version: " + this.getVersionNumber() + "Bettery Percentage: " + this.getBatteryPercentage() + " Carrier: " + this.getCarrier());
    }
}

