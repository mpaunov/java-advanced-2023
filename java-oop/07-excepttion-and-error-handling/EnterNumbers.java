import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {

    private static class InvalidNumberException extends RuntimeException {

        public InvalidNumberException(String message) {
            super(message);
        }

        public InvalidNumberException(String message, Exception cause) {
            super(message, cause);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() != 10) {
            try {
                readNumber(numbers, scanner.nextLine());
            } catch (InvalidNumberException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(
                numbers.stream()
                        .map(String::valueOf).collect(Collectors.joining(", "))
        );

    }

    private static void readNumber(List<Integer> numbers, String input) {

        int num = -1;

        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("Invalid Number!", e);
        }

        int start = numbers.isEmpty() ? 1 : numbers.get(numbers.size() - 1);
        int end = 100;

        if (num <= start || num >= end) {
            throw new InvalidNumberException(
                    String.format("Your number is not in range %d - %d!", start, end)
            );
        }

        numbers.add(num);
    }

}
