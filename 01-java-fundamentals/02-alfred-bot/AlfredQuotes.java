import java.util.Date;

public class AlfredQuotes {
    //basic greeting
    public String basicGreeting() {
        return "Hello sir, how are you?";
    }

    //greetig with day period and name
    public String guestGreeting(String name, String dayPeriod) {
        //added the space after "Good" after i compiled.
        return "Good " + dayPeriod + ", " + name + ". Lovely to see you";
    }

    //provide the date
    public String provideDate() {
        Date date = new Date();
        return "The current date is " + date;
    }
    
    //conversaton method
    public String conversation(String conversation) {
        //if Alexis is mentioned
        if(conversation.contains("Alexis")) {
            return "I'm sure I can do a much better job!";
        //if Alfred is mentioned
        } else if(conversation.contains("Alfred")) {
            return "Thank you for aknowledging me, right away";
        //if neither Alfred nor Alexis are mentioned
        } else {
            return "Interesting thought, please continue";
        }
    }
}

