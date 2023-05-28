import java.util.List;
import java.util.Scanner;

public class Appointment {
    private Vet vet;
    private String time;

    public Appointment(Vet vet, String time) {
        this.vet = vet;
        this.time = time;
    }

    public Vet getVet() {
        return vet;
    }
    public String getTime() {
        return time;
    }