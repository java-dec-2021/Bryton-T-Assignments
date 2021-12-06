public class BasicsTest {
    public static void main(String[] args) {
        Basics test = new Basics();
        test.printAll();
        test.printOdds();
        System.out.println(test.sigma255());
        int[] someArray = {1,3,5,7,9,13};
        test.printArray(someArray);
        int[] someArray2 = {1, -9978, 23, 743, -343, 4540};
        test.findMax(someArray2);
        test.oddNumbersArray();
    }   
}
