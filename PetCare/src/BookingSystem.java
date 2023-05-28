
public class BookingSystem {

    public static boolean checkAvailability(Vet vet, String desiredTime) {
        return vet.isAvailable(desiredTime);
    }
}
