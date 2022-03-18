public class Booth {

    private String patientName;
    private int boothNum;
    private int vaccineAmount;

    //creating the constructor.
    public Booth(String patientName) {

        this.setPatientName(patientName);
    }

    public String getPatientName() {

        return patientName;
    }

    public void setPatientName(String patientName) {

        this.patientName = patientName;
    }

    public int getBoothNum() {

        return boothNum;
    }

    public void setBoothNum(int boothNum) {

        this.boothNum = boothNum;
    }

    public int getVaccineAmount() {

        return vaccineAmount;
    }

    public void setVaccineAmount(int vaccineAmount) {

        this.vaccineAmount = vaccineAmount;
    }

}
