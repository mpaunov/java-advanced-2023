package borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();

        while (!line.equalsIgnoreCase("end")) {

            String[] tokens = line.split("\\s+");

            Identifiable identifiable;
            if (tokens.length == 2) {
                identifiable = new Robot(tokens[0], tokens[1]);
            } else {
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }
            identifiables.add(identifiable);

            line = scanner.nextLine();
        }

        String fakeIdsEndPattern = scanner.nextLine();

        identifiables.stream()
                .filter(i -> i.getId().endsWith(fakeIdsEndPattern))
                .forEach(i -> System.out.println(i.getId()));
    }
}
