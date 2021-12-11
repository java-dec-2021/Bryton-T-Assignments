public class ProjectTest {
    public static void main(String[] args) {
        Project alpha = new Project("alpha project", "this is the first project");
        alpha.elevatorPitch();

        Project beta = new Project();
        beta.setName("beta project");
        beta.setDesc("This is the second project");
        beta.elevatorPitch();

        Project charlie = new Project("Charlie Project");
        charlie.setDesc("this is the third project");
        charlie.elevatorPitch();

        String charliePitchDesc = charlie.getDesc();
        String charliePitchName = charlie.getName();
        System.out.println("The best thing about the " + charliePitchName + " is that " + charliePitchDesc);
    }   
}
