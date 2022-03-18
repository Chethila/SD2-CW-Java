import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaccinationCenter {

    //declaring global variables.
    static String patientName;
    static int boothNum = 0;
    static int vaccineAmount = 150;
    static Scanner input = new Scanner(System.in);

    //declaring the main array.
    static String[] VaccinationCenter = new String[6];

    public static void main(String[] args) throws IOException {

        //calling the initialise array function.
        initialise(VaccinationCenter);

        //menu bar and the functions inside a while loop with if-else block.
        String userInput;

        while (true) {
            System.out.println("Enter 100 or VVB: View all Vaccination Booths");
            System.out.println("Enter 101 or VEB: View all Empty Booths");
            System.out.println("Enter 102 or APB: Add Patient to a Booth");
            System.out.println("Enter 103 or RPB: Remove Patient from a Booth");
            System.out.println("Enter 104 or VPS: View Patients Sorted in alphabetical order");
            System.out.println("Enter 105 or SPD: Store Program Data into file");
            System.out.println("Enter 106 or LPD: Load Program Data from file");
            System.out.println("Enter 107 or VRV: View Remaining Vaccinations");
            System.out.println("Enter 108 or AVS: Add Vaccinations to the Stock");
            System.out.println("Enter 999 or EXT: Exit the Program");

            userInput = input.nextLine();

            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")) {       //show all vaccination booths.
                viewAllBooths();
            }

            else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {  //show the empty booths.
                viewEmpty();
            }

            else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {  //add a patient to the booth.
                addPatient();
            }


            else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {  //remove a patient from a booth.
                removePatient();
            }

            else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {  //view patients in the alphabetical order.
                sortPatient();
            }

            else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {  //store data in to a file.
                writeFile();
            }

            else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {  //load data from the file.
                readFile();
            }

            else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {  //remaining vaccines.
                viewStock();
            }

            else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {  //add vaccines.
                updateStock();
            }

            else if (userInput.equals("999") || userInput.equalsIgnoreCase("EXT")) {  //exit the programme.
                System.out.println("Have a Nice Day!");
                break;
            }

            else {
                System.out.println("The input is invalid, Please enter a Valid input");
            }
        }
    }


    //methods initialising.

    public static void initialise(String[] boothRef){
        for (int i = 0; i < 6; i++) {
            boothRef[i] = "empty" ;
        }
        System.out.println("initialised");
    }

    public static void viewAllBooths() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Vaccination Booth"+" "+i+" "+VaccinationCenter[i]);
        }
        System.out.println(" ");
    }

    public static void viewEmpty() {
        for (int x = 0; x < 6; x++) {
            if (VaccinationCenter[x].equals("empty")) {
                System.out.println("The booth"+" "+ x +" "+"is"+" " + VaccinationCenter[x]);
            }
        }
        System.out.println(" ");
    }

    public static void addPatient() {
        System.out.print("Enter the name of the patient :");
        Scanner input1 = new Scanner(System.in);
        patientName = input1.next();
        System.out.print("Enter the booth number :");
        Scanner input2 = new Scanner(System.in);
        boothNum = input2.nextInt();
        VaccinationCenter[boothNum] = patientName;
        vaccineAmount = vaccineAmount - 1;
        System.out.println(" ");
    }

    public static void removePatient() {
        System.out.print("Enter the booth number you need to remove a patient :");
        Scanner input3 = new Scanner(System.in);
        boothNum = input3.nextInt();
        VaccinationCenter[boothNum] = "empty" ;
        System.out.println(" ");
    }

    public static void sortPatient() {
        String temp;
        String [] tempVaccinationCenter = new String[6];
        for (int z = 0; z < 6; z++) {
            tempVaccinationCenter[z] = VaccinationCenter[z];
        }
        for (int j = 0; j < 6; j++) {
            for (int k = j+1; k < 6; k++) {
                if (tempVaccinationCenter[j].compareToIgnoreCase(tempVaccinationCenter[k]) > 0 ) {
                    temp = tempVaccinationCenter[j];
                    tempVaccinationCenter[j] = tempVaccinationCenter[k];
                    tempVaccinationCenter[k] = temp;
                }
            }
        }
        System.out.println("The Vaccination Center patients in Alphabetical order are:");
        for (int j = 0; j < 6; j++) {
            if (tempVaccinationCenter[j].equalsIgnoreCase("empty")) {
                System.out.println("_");
            }
            else {
                System.out.println(tempVaccinationCenter[j]);
            }
        }
        System.out.println(" ");
    }

    public static void writeFile() throws IOException {
        File vaccinationData = new File("VaccinationInfo.txt");
        FileWriter writeVaccine = new FileWriter(vaccinationData);
        for (int z = 0; z < 6; z++) {
            writeVaccine.write("The Booth Number"+" "+z+" "+"is"+" "+VaccinationCenter[z]+"\n");
        }
        writeVaccine.close();
        System.out.println(" ");
    }

    public static void readFile() throws FileNotFoundException {
        File vaccinationData = new File("VaccinationInfo.txt");
        Scanner readVaccine = new Scanner(vaccinationData);
        while (readVaccine.hasNextLine()) {
            String information = readVaccine.nextLine();
            System.out.println(information);
        }
        readVaccine.close();
        System.out.println(" ");
    }

    public static void viewStock() {
        System.out.println("The remaining number of Vaccinations"+" "+vaccineAmount);
        if (vaccineAmount < 20) {
            System.out.println("WARNING! Only 20 vaccines are remaining");
        }
        System.out.println(" ");
    }

    public static void updateStock() {
        Scanner input4 = new Scanner(System.in);
        System.out.print("Enter the number of new vaccinations received :");
        int vaccineNum = input4.nextInt();
        vaccineAmount = vaccineAmount + vaccineNum;
        System.out.println(" ");
    }

}
