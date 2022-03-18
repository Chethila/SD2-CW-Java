import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VaccinationCenterExtended {

    //declaring the variables
    static String firstName;
    static String surname;
    static String age;
    static String city;
    static String NIC;
    static String vaccineType;
    static int boothNum;
    static int vaccineAmount = 150;
    static int AZCount = 0;
    static int SPCount = 0;
    static int PFCount = 0;

    public static void main(String[] args) throws IOException {

        //declaring the main array 'booths'
        Booth[] VaccinationCenter = new Booth[6];

        //initialising for empty
        for (int i = 0; i < 6; i++) {
            firstName = "empty" ;
            VaccinationCenter[i] = new Booth(firstName);
        }

        //declaring the patient array.
        Patient[] PatientData = new Patient[6];

        //inisialising the array.
        for (int i = 0; i < 6; i++) {
            firstName = "empty";
            surname = "-";
            age = "-";
            city = "-";
            NIC = "-";
            vaccineType = "-";

            PatientData[i] = new Patient(firstName,surname,age,city,NIC,vaccineType);
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
            System.out.println("Enter 109 or VAD: View Additional Data");
            System.out.println("Enter 999 or EXT: Exit the Program");

            userInput = input1.nextLine();

            //show all vaccination booths.
            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")) {
                for (int x = 0; x < 6; x++) {
                    System.out.println("Vaccination Booth"+" "+x+" "+ VaccinationCenter[x].getfirstName()+" "+PatientData[x].getSurname());
                }
                System.out.println(" ");
            }

            //show the empty booths.
            else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {
                for (int i = 0; i < 6; i++) {
                    if (VaccinationCenter[i].getfirstName().equalsIgnoreCase("empty")) {
                        System.out.println("The booth"+" "+ i +" "+"is"+" " + VaccinationCenter[i].getfirstName());
                    }
                }
                System.out.println(" ");
            }

            //add a patient to the booth.
            else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {

                Scanner input2 = new Scanner(System.in);
                System.out.println("Enter the patient First name :");
                firstName = input2.next();

                Scanner input6 = new Scanner(System.in);
                System.out.println("Enter the Surname name :");
                surname = input6.next();

                Scanner input7 = new Scanner(System.in);
                System.out.println("Enter the Age :");
                age = input7.next();

                Scanner input8 = new Scanner(System.in);
                System.out.println("Enter the City you live :");
                city = input8.next();

                Scanner input9 = new Scanner(System.in);
                System.out.println("Enter the NIC number :");
                NIC = input9.next();

                Scanner input10 = new Scanner(System.in);
                System.out.println("Enter the Required Vaccine :");
                System.out.println("There are 3 types of vaccines - \n AstraZeneca \n Sinopharm \n Pfizer");
                vaccineType = input10.next();

                if (vaccineType.equalsIgnoreCase("AstraZeneca")) {
                    if (AZCount < 2) {
                        for (int i = 0; i < 2; i++) {
                            if (PatientData[i].getFirstName().equalsIgnoreCase("empty")) {
                                System.out.println("The booth"+" "+i+" "+"is"+" "+PatientData[i].getFirstName());
                                System.out.println("You will be directed to booth"+" "+i);
                                VaccinationCenter[i].setfirstName(firstName);
                                PatientData[i].setFirstName(firstName);
                                PatientData[i].setSurname(surname);
                                PatientData[i].setAge(age);
                                PatientData[i].setCity(city);
                                PatientData[i].setNIC(NIC);
                                PatientData[i].setVaccineType(vaccineType);
                                AZCount++;

                                vaccineAmount = vaccineAmount - 1;
                                System.out.println(" ");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("Sorry! There are no any empty booths.");
                    }
                }

                else if (vaccineType.equalsIgnoreCase("Sinopharm")) {
                    if (SPCount < 2) {
                        for (int i = 2; i < 4; i++) {
                            if (PatientData[i].getFirstName().equalsIgnoreCase("empty")) {
                                System.out.println("The booth"+" "+i+" "+"is"+" "+PatientData[i].getFirstName());
                                System.out.println("You will be directed to booth"+" "+i);
                                VaccinationCenter[i].setfirstName(firstName);
                                PatientData[i].setFirstName(firstName);
                                PatientData[i].setSurname(surname);
                                PatientData[i].setAge(age);
                                PatientData[i].setCity(city);
                                PatientData[i].setNIC(NIC);
                                PatientData[i].setVaccineType(vaccineType);
                                SPCount++;

                                vaccineAmount = vaccineAmount - 1;
                                System.out.println(" ");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("Sorry! There are no any empty booths.");
                    }
                }

                else if (vaccineType.equalsIgnoreCase("Pfizer")) {
                    if (PFCount < 2) {
                        for (int i = 4; i < 6; i++) {
                            if (PatientData[i].getFirstName().equalsIgnoreCase("empty")) {
                                System.out.println("The booth"+" "+i+" "+"is"+" "+PatientData[i].getFirstName());
                                System.out.println("You will be directed to booth"+" "+i);
                                VaccinationCenter[i].setfirstName(firstName);
                                PatientData[i].setFirstName(firstName);
                                PatientData[i].setSurname(surname);
                                PatientData[i].setAge(age);
                                PatientData[i].setCity(city);
                                PatientData[i].setNIC(NIC);
                                PatientData[i].setVaccineType(vaccineType);
                                PFCount++;

                                vaccineAmount = vaccineAmount - 1;
                                System.out.println(" ");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("Sorry! There are no any empty booths.");
                    }
                }
                else {
                    System.out.println("The Vaccine you entered is incorrect. Please re-enter the vaccine type.");
                }
            }

            //remove a patient from a booth.
            else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {
                System.out.println("Enter the booth number you need to remove a patient :");
                Scanner input4 = new Scanner(System.in);
                boothNum = input4.nextInt();
                if(boothNum == 0 || boothNum == 1){
                    AZCount--;
                }
                if(boothNum == 2 || boothNum == 3){
                    SPCount--;
                }
                if(boothNum == 4 || boothNum == 5){
                    PFCount--;
                }

                System.out.println(VaccinationCenter[boothNum].getfirstName()+" "+"is removed");
                VaccinationCenter[boothNum].setfirstName("empty");
                PatientData[boothNum].setFirstName("empty");
                PatientData[boothNum].setSurname(" ");
                PatientData[boothNum].setAge(" ");
                PatientData[boothNum].setCity(" ");
                PatientData[boothNum].setNIC(" ");
                PatientData[boothNum].setVaccineType(" ");

                System.out.println(" ");
            }

            //view patients in the alphabetical order.
            else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {
                String temp;
                String [] tempVaccinationCenter = new String[6];
                for (int z = 0; z < 6; z++) {
                    tempVaccinationCenter[z] = VaccinationCenter[z].getfirstName()+" "+PatientData[z].getSurname();
                }
                for (int j = 0; j < 6; j++) {
                    for (int k = j+1; k < 6; k++) {
                        if (tempVaccinationCenter[j].compareToIgnoreCase(tempVaccinationCenter[k]) > 0) {
                            temp = tempVaccinationCenter[j];
                            tempVaccinationCenter[j] = (tempVaccinationCenter[k]);
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

            //store data in to a file.
            else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {
                File vaccinationData = new File("VaccinationInfo.txt");
                FileWriter writeVaccine = new FileWriter(vaccinationData);
                for (int z = 0; z < 6; z++) {
                    writeVaccine.write("The Booth Number"+" "+z+" "+"is"+" "+VaccinationCenter[z].getfirstName()+" "+PatientData[z].getSurname()+"\n");
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

            //view additional data.
            else if (userInput.equals("109") || userInput.equalsIgnoreCase("VAD")) {
                for (int i = 0; i < 6; i++) {
                    System.out.println("First Name :" + " "+PatientData[i].getFirstName());
                    System.out.println("Last Name :" + " "+PatientData[i].getSurname());
                    System.out.println("Age :" + " "+PatientData[i].getAge());
                    System.out.println("City :" + " "+PatientData[i].getCity());
                    System.out.println("NIC :" + " "+PatientData[i].getNIC());
                    System.out.println("The type of Vaccine :" + " "+PatientData[i].getVaccineType());
                    System.out.println(" ");
                }
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
