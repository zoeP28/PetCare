import java.util.ArrayList;
import java.util.Scanner;

public class HealthRecord {
    private String date;
    private String description;
    private String type;
    private User user;

    private static ArrayList<String> vaccinations;
    private static ArrayList<String> medications;
    private static ArrayList<String> allergies;
    private static ArrayList<String> surgicalProcedures;


    public HealthRecord(ArrayList<String> vaccinations, ArrayList<String> medications, ArrayList<String> allergies, ArrayList<String> surgicalProcedures) {
        HealthRecord.vaccinations = vaccinations;
        HealthRecord.medications = medications;
        HealthRecord.allergies = allergies;
        HealthRecord.surgicalProcedures = surgicalProcedures;
    }

    public HealthRecord(String s, String s1, String s2, String s3) {
    }

    public static void display() {
        System.out.println("Vaccinations:");
        for (String vaccination : vaccinations) {
            System.out.println("- " + vaccination);
        }

        System.out.println("Medications:");
        for (String medication : medications) {
            System.out.println("- " + medication);
        }

        System.out.println("Allergies:");
        for (String allergy : allergies) {
            System.out.println("- " + allergy);
        }

        System.out.println("Surgical procedures:");
        for (String procedure : surgicalProcedures) {
            System.out.println("- " + procedure);
        }
    }

    public String getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

    public String getType(){
        return type;
    }

    public void addPet(){
        Pet newPet = Form.fillForm();
        user.addPet(newPet);
        System.out.println("Pet added successfully!");
    }
}