import java.util.Random;
import java.util.ArrayList;

public class Puzzling {
    public ArrayList getTenRolls() {
        Random dice = new Random();
        ArrayList results = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int roll = 1 + dice.nextInt(20);
            results.add(roll);
        }
        return results;
    }
    
    public char getRandomLetter(){
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Random letterSel = new Random();
        int letterIndex = letterSel.nextInt(26);
        return letters[letterIndex];
    }

    public String generatePassword(){
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    public ArrayList getNewPasswordSet(int num) {
        ArrayList passwords = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            passwords.add(generatePassword());
        }
        return passwords;
    }
}