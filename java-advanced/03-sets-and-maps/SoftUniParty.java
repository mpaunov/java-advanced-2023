import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String guest = scanner.nextLine();

        while (!guest.equals("PARTY")) {

            char startsWith = guest.charAt(0);

            if (Character.isDigit(startsWith)) {
                vip.add(guest);
            } else {
                regular.add(guest);
            }

            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();

        while (!guest.equals("END")) {
            vip.remove(guest);
            regular.remove(guest);
            guest = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String g : vip) {
            System.out.println(g);
        }

        for (String g : regular) {
            System.out.println(g);
        }

    }
}
