import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!"END".equals(input)) {

            String[] tokens = input.split(", ");

            String direction = tokens[0];
            String registration = tokens[1];

            if (direction.equals("IN")) {
                parkingLot.add(registration);
            } else {
                parkingLot.remove(registration);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String reg : parkingLot) {
                System.out.println(reg);
            }
        }

    }

}
