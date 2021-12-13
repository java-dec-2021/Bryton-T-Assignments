public class PhoneTester {
    public static void main(String[] args) {
        Galaxy s9 = new Galaxy("S9", 100, "t-mobile", "RING! RING! RING!");
        Iphone iphone10 = new Iphone("X", 100, "Verison", "Buzz. Buzz. Buzz");
        s9.displayInfo();
        System.out.println(s9.ring());
        System.out.println(s9.unlock());

        iphone10.displayInfo();
        System.out.println(iphone10.ring());
        System.out.println(iphone10.unlock());
    }
}
