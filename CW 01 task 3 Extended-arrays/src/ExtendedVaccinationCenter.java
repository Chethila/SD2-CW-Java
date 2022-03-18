import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtendedVaccinationCenter {
    //declaring global variables.
    static String patientFirstName;
    static String patientLastName;
    static int vaccineType;
    static int boothNum = 0;
    static int vaccineAmount = 150;
    static int AZCount = 0;
    static int SPCount = 0;
    static int PFCount = 0;

    //declaring the main array.
    static String[] VaccinationCenter = new String[6];
    static String[] VaccinationCenter2 = new String[6];

    public static void main(String[] args) throws IOException {

        //calling the initialise array function.
        initialise(VaccinationCenter);

        //setting the 2nd array as an " " array.
        for (int a = 0; a < 6; a++) {
            VaccinationCenter2[a] = " " ;
        }

        Scanner input = new Scanner(System.in);

        //menu bar and the functions inside a while loop with if-else block.

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

            String userInput = input.nextLine();

            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")) {       //show all vaccination booths.
                viewAllBooths();
                System.out.println(" ");
            }

            else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {  //show the empty booths.
                viewEmpty();
                System.out.println(" ");
            }

            else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {  //add a patient to the booth.
                addPatient();
                System.out.println(" ");
            }


            else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {  //remove a patient from a booth.
                removePatient();
                System.out.println(" ");
            }

            else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {  //view patients in the alphabetical order.
                sortPatient();
                System.out.println(" ");
            }

            else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {  //store data in to a file.
                writeFile();
                System.out.println(" ");
            }

            else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {  //load data from the file.
                readFile();
                System.out.println(" ");
            }

            else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {  //remaining vaccines.
                viewStock();
                System.out.println(" ");
            }

            else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {  //add vaccines.
                updateStock();
                System.out.println(" ");
            }

            else if (userInput.equals("999") || userInput.equalsIgnoreCase("EXT")) {  //exit the programme.
                System.out.println("Have a Nice Day!");
                break;
            }

            else {
                System.out.println("The input is invalid, Please enter a Valid input");
                System.out.println(" ");
            }
        }
    }


    //methods initialising.

    public static void initialise(String[] boothRef){                //inisialising the array for empty.
        for (int i = 0; i < 6; i++) {
            boothRef[i] = "empty" ;
        }
        System.out.println("initialised");
    }

    public static void viewAllBooths() {                             //function for view all booths.
        for (int i = 0; i < 6; i++) {
            System.out.println("Vaccination Booth"+" "+i+" "+VaccinationCenter[i]+" "+VaccinationCenter2[i]);
        }
    }

    public static void viewEmpty() {                                 //function for view empty booths.
        for (int x = 0; x < 6; x++) {
            if (VaccinationCenter[x].equals("empty")) {
                System.out.println("The booth"+" "+ x +" "+"is"+" " + VaccinationCenter[x]);
            }
        }
    }

    public static void addPatient() {                                //function for add a patient to a booth.
        //asking the first name of the patient.
        System.out.print("Enter the First name of the patient :");
        Scanner input1 = new Scanner(System.in);
        patientFirstName = input1.next();

        //asking the last name of the patient.
        System.out.print("Enter the Last name of the patient :");
        Scanner input5 = new Scanner(System.in);
        patientLastName = input5.next();

        //asking the vaccine type from the patient.
        System.out.print("Enter the Vaccine type you prefer : \n 1 for  AstraZeneca \n 2 for  Sinopharm \n 3 for  Pfizer");
        Scanner input6 = new Scanner(System.in);
        vaccineType = input6.nextInt();

        if (vaccineType == 1) {
            if (AZCount < 2) {
                for (int i = 0; i < 2; i++) {
                    if (VaccinationCenter[i].equalsIgnoreCase("empty")) {
                        System.out.println("The booth"+" "+i+" "+"is"+" "+VaccinationCenter[i]);
                        System.out.println("You will be directed to booth"+" "+i);
                        VaccinationCenter[i] = patientFirstName;
                        VaccinationCenter2[i] = patientLastName;
                        vaccineAmount = vaccineAmount - 1;
                        AZCount++;
                        break;
                    }
                }
            }
            else {
                System.out.println("Sorry! There are no any empty booths.");
            }
        }

        else if (vaccineType == 2) {
            if (SPCount < 2) {
                for (int i = 2; i < 4; i++) {
                    if (VaccinationCenter[i].equalsIgnoreCase("empty")) {
                        System.out.println("The booth"+" "+i+" "+"is"+" "+VaccinationCenter[i]);
                        System.out.println("You will be directed to booth"+" "+i);
                        VaccinationCenter[i] = patientFirstName;
                        VaccinationCenter2[i] = patientLastName;
                        SPCount++;
                        break;
                    }
                }
            }
            else {
                System.out.println("Sorry! There are no any empty booths.");
            }
        }

        else if (vaccineType == 3) {
            if (PFCount < 2) {
                for (int i = 4; i < 6; i++) {
                    if (VaccinationCenter[i].equalsIgnoreCase("empty")) {
                        System.out.println("The booth"+" "+i+" "+"is"+" "+VaccinationCenter[i]);
                        System.out.println("You will be directed to booth"+" "+i);
                        VaccinationCenter[i] = patientFirstName;
                        VaccinationCenter2[i] = patientLastName;
                        PFCount++;
                        break;
                    }
                }
            }
            else {
                System.out.println("Sorry! There are no any empty booths.");
            }
        }

        else {
            System.out.println(" ");
        }
    }

    public static void removePatient() {                               //function for remove a patient from a booth.
        System.out.print("Enter the booth number you need to remove a patient :");
        Scanner input3 = new Scanner(System.in);
        boothNum = input3.nextInt();
        if(boothNum == 0 || boothNum == 1){
            AZCount--;
        }
        if(boothNum == 2 || boothNum == 3){
            SPCount--;
        }
        if(boothNum == 4 || boothNum == 5){
            PFCount--;
        }

        VaccinationCenter[boothNum] = "empty" ;
        VaccinationCenter2[boothNum] = " " ;
        System.out.println("The patient in booth"+" "+boothNum+" "+"removed successfully.");
    }

    public static void sortPatient() {                         //function for sorting the booths for alphabetical order.
        String temp;
        String [] tempVaccinationCenter = new String[6];
        for (int z = 0; z < 6; z++) {
            tempVaccinationCenter[z] = VaccinationCenter[z]+" "+VaccinationCenter2[z];
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
    }

    public static void writeFile() throws IOException {                     //function for write the booth details to  file.
        File vaccinationData = new File("VaccinationInfo.txt");
        FileWriter writeVaccine = new FileWriter(vaccinationData);
        for (int z = 0; z < 6; z++) {
            writeVaccine.write("The Booth Number"+" "+z+" "+"is"+" "+VaccinationCenter[z]+" "+VaccinationCenter2[z]+"\n");
        }
        writeVaccine.close();
    }

    public static void readFile() throws FileNotFoundException {            //function for read data from a file.
        File vaccinationData = new File("VaccinationInfo.txt");
        Scanner readVaccine = new Scanner(vaccinationData);
        while (readVaccine.hasNextLine()) {
            String information = readVaccine.nextLine();
            System.out.println(information);
        }
        readVaccine.close();
    }

    public static void viewStock() {                //function for view the remaining vaccine count.
        System.out.println("The remaining number of Vaccinations"+" "+vaccineAmount);
        if (vaccineAmount < 20) {
            System.out.println("WARNING! Only 20 vaccines are remaining");
        }
    }

    public static void updateStock() {               //function for add new vaccine stocks.
        Scanner input4 = new Scanner(System.in);
        System.out.print("Enter the number of new vaccinations received :");
        int vaccineNum = input4.nextInt();
        vaccineAmount = vaccineAmount + vaccineNum;
    }

}
