public class FizzBuzz {
    public String fizzBuzz(int num) {
        //can also be if(num % 3 == 0 && num % 5 == 0) {
        if(num % 15 == 0) {
            return "FizBuzz";
        } else if(num % 3 == 0){
            return "Fizz";
        } else if(num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }
}
