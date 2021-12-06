public class PuzzlingTest {
    public static void main(String[] args) {
        Puzzling test = new Puzzling();
        System.out.println(test.getTenRolls());
        System.out.println(test.getRandomLetter());
        System.out.println(test.generatePassword());
        System.out.println(test.getNewPasswordSet(4));
    }
}
