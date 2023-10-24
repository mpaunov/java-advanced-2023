import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        int size = readInput();
        printRhombus(size);
    }

    private static int readInput() {
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    private static void printRhombus(int size) {
        for (int i = 1; i <= size; i++) {
            printRhombusLine(size, i);
        }

        for (int i = size - 1; i >= 1; i--) {
            printRhombusLine(size, i);
        }
    }

    private static void printRhombusLine(int rows, int currentRow) {
        for (int i = 0; i < rows - currentRow; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < currentRow; i++) {
            System.out.print("* ");
        }

        System.out.println();
    }

}
