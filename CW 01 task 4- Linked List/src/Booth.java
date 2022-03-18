public class Booth {

    private String firstName;
    private int boothNum;

    //creating the constructor.
    public Booth(String firstName) {

        this.setfirstName(firstName);
    }

    public String getfirstName() {

        return firstName;
    }

    public void setfirstName(String patientName) {

        this.firstName = patientName;
    }

    public int getBoothNum() {

        return boothNum;
    }

    public void setBoothNum(int boothNum) {

        this.boothNum = boothNum;
    }

}
