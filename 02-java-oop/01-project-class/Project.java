public class Project {
    private String name;
    private String desc;
    public Project() {

    }
    public Project(String nameParam) {
        this.name = nameParam;
    }
    public Project(String nameParam, String descParam) {
        this.name = nameParam;
        this.desc = descParam;
    }

    public void setName(String setNameParam) {
        name = setNameParam;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String setDescParam) {
        desc = setDescParam;
    }

    public String getDesc() {
        return desc;
    }

    public void elevatorPitch() {
        System.out.println(this.getName() + " : " + this.getDesc());
    }
}
