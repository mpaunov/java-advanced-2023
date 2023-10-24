import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = range[0];
        int end = range[1];

        String condition = scanner.nextLine();

        if (condition.equals("odd")) {
            printRange(begin, end, v -> v % 2 != 0);
        } else {
            printRange(begin, end, v -> v % 2 == 0);
        }

    }

    private static void printRange(int begin, int end, IntPredicate predicate) {
        IntStream.rangeClosed(begin, end)
                .filter(predicate)
                .forEach(n -> System.out.print(n + " "));

    }
}
