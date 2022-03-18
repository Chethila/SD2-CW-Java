import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaccinationCenter {

    //declaring the variables
    static String patientName;
    static int boothNum;
    static int vaccineAmount = 150;

    public static void main(String[] args) throws IOException {

        //declaring the main array 'booths'
        Booth[] VaccinationCenter = new Booth[6];

        //initialising for empty
        for (int i = 0; i < 6; i++) {
            patientName = "empty" ;
            VaccinationCenter[i] = new Booth(patientName);
        }

        //declaring the scanner inputs.
        Scanner input1 = new Scanner(System.in);

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

            userInput = input1.nextLine();

            //show all vaccination booths.
            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")) {
                for (int x = 0; x < 6; x++) {
                    System.out.println("Vaccination Booth"+" "+x+" "+ VaccinationCenter[x].getPatientName());
                }
                System.out.println(" ");
            }

            //show the empty booths.
            else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {
                for (int i = 0; i < 6; i++) {
                    if (VaccinationCenter[i].getPatientName().equalsIgnoreCase("empty")) {
                        System.out.println("The booth"+" "+ i +" "+"is"+" " + VaccinationCenter[i].getPatientName());
                    }
                }
                System.out.println(" ");
            }

            //add a patient to the booth.
            else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {

                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the patient name :");
                patientName = input2.next();
                Scanner input3 = new Scanner(System.in);
                System.out.println("Enter the booth number :");
                boothNum = input3.nextInt();
                VaccinationCenter[boothNum].setPatientName(patientName);
                vaccineAmount = vaccineAmount - 1 ;
                System.out.println(" ");
            }

            //remove a patient from a booth.
            else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {
                System.out.println("Enter the booth number you need to remove a patient :");
                Scanner input4 = new Scanner(System.in);
                boothNum = input4.nextInt();
                System.out.println(VaccinationCenter[boothNum].getPatientName()+" "+"is removed");
                VaccinationCenter[boothNum].setPatientName("empty");
                System.out.println(" ");
            }

            //view patients in the alphabetical order.
            else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {
                String temp;
                for (int j = 0; j < 6; j++) {
                    for (int k = j+1; k < 6; k++) {
                        if (VaccinationCenter[j].getPatientName().compareToIgnoreCase(VaccinationCenter[k].getPatientName()) > 0) {
                            temp = VaccinationCenter[j].getPatientName();
                            VaccinationCenter[j].setPatientName(VaccinationCenter[k].getPatientName());
                            VaccinationCenter[k].setPatientName(temp);
                        }
                    }
                }
                System.out.println("The Vaccination Center patients in Alphabetical order are:");
                for (int j = 0; j < 6; j++) {
                    if (VaccinationCenter[j].getPatientName().equalsIgnoreCase("empty")) {
                        System.out.println("_");
                    }
                    else {
                        System.out.println(VaccinationCenter[j].getPatientName());
                    }
                }
                System.out.println(" ");
            }

            //store data in to a file.
            else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {
                File vaccinationData = new File("VaccinationInfo.txt");
                FileWriter writeVaccine = new FileWriter(vaccinationData);
                for (int z = 0; z < 6; z++) {
                    writeVaccine.write("The Booth Number"+" "+z+" "+"is"+" "+VaccinationCenter[z].getPatientName()+"\n");
                }
                writeVaccine.close();
                System.out.println(" ");
            }

            //load data from the file.
            else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {
                File vaccinationData = new File("VaccinationInfo.txt");
                Scanner readVaccine = new Scanner(vaccinationData);
                while (readVaccine.hasNextLine()) {
                    String information = readVaccine.nextLine();
                    System.out.println(information);
                }
                readVaccine.close();
                System.out.println(" ");
            }

            //remaining vaccines.
            else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {
                System.out.println("The remaining number of Vaccinations"+" "+vaccineAmount);
                if (vaccineAmount < 20) {
                    System.out.println("WARNING! Only 20 vaccines are remaining");
                }
                System.out.println(" ");
            }

            //add vaccines.
            else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {
                    Scanner input4 = new Scanner(System.in);
                    System.out.print("Enter the number of new vaccinations received :");
                    int vaccineNum = input4.nextInt();
                    vaccineAmount = vaccineAmount + vaccineNum;
            }

            //exit the programme.
            else if (userInput.equals("999") || userInput.equalsIgnoreCase("EXT")) {
                System.out.println("Have a Nice Day!");
                break;
            }

            //checking the inputs validity.
            else {
                System.out.println("The input is invalid, Please enter a Valid input");
            }
        }
    }
}
