public class Patient {

    //inisialising the variables.
    private String firstName;
    private String surname;
    private String age;
    private String city;
    private String NIC;
    private String vaccineType;
    private int vaccineAmount = 150;

    //building the constructor.
    public Patient(String firstName, String surname, String age, String city, String NIC, String vaccineType) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.NIC = NIC;
        this.vaccineType = vaccineType;
    }

    //building the getters and setters.


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public int getVaccineAmount() {
        return vaccineAmount;
    }

    public void setVaccineAmount(int vaccineAmount) {
        this.vaccineAmount = vaccineAmount;
    }
}
