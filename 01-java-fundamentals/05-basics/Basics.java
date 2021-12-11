import java.util.ArrayList;

public class Basics {
    //Prints all num 1-255
    public void printAll() {
        for (int x = 1; x <= 255; x++) {
            System.out.println(x);
        }
    }

    //Prints odd num 1-255
    public void printOdds() {
        for (int x = 1; x <= 255; x++) {
            if (x % 2 != 0) {
                System.out.println(x);
            }
        }
    }

    //Finds Sigma(255) (returns but does not print to Terminal)
    public int sigma255() {
        int sum = 0;
        for (int x = 0; x <= 255; x++) {
            sum = sum + x;
        }
        return sum;
    }

    //Iterate through Array (array argument needed)
    public void printArray(int arr[]) {
        for (int ele : arr) {
            System.out.println(ele);
        }
    }

    //Find Max value of an Array
    public void findMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if(ele > max) max = ele;
        }
        System.out.println("Max Number in Array is: " + max);
    }

    //Creates array of odd num
    public void oddNumbersArray(){
        ArrayList y = new ArrayList<>();
        for(int x = 1; x <= 255; x++) {
            if(x % 2 != 0) {
                y.add(x);
            }
        }
        System.out.println(y);
    }

    //Averages entries in an Array
    public void 
}
