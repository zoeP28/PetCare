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