public class AlfredTest {
    public static void main(String[] args) {
        
        //import all methods from AlfredQuotes
        AlfredQuotes quotes = new AlfredQuotes();

        String testGreeting = quotes.basicGreeting();
        String guestGreeting = quotes.guestGreeting("Bryton Tateishi", "morning");
        String alexisTest = quotes.conversation("Alexis, add butter to my shopping list");
        String alfredTest = quotes.conversation("Alfred, call my mom");
        String neitherTest = quotes.conversation("What do you think of Zebras?");

        System.out.println(testGreeting);
        System.out.println(guestGreeting);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(neitherTest);
    }
}