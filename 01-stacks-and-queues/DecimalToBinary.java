import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (number != 0) {
            int reminder = number % 2;
            stack.push(reminder);
            number = number / 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }

}
