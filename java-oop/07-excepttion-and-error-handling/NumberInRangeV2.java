import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class NumberInRangeV2 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = range[0];
        int end = range[1];

        System.out.println("Range: [" + begin + "..." + end + "]");

        String input = scanner.nextLine();

        while (!validInput(input, begin, end)) {
            input = scanner.nextLine();
        }

    }

    private static boolean validInput(String input, int begin, int end) {
        boolean numberInValid = isStringInteger(input);

        int number = 0;

        if (numberInValid) {
            number = Integer.parseInt(input);
            numberInValid = number >= begin && number <= end;
        }

        String output = numberInValid
                ? String.format("Valid number: %d", number)
                : String.format("Invalid number: %s", input);

        System.out.println(output);

        return numberInValid;
    }

    public static boolean isStringInteger(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
