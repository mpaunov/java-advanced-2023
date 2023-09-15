import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int[] arr = readArray(scanner);

        int wrongValue = matrix[arr[0]][arr[1]];

        List<int[]> correctedValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue) {
                    int actualValue = 0;

                    // Top
                    if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != wrongValue) {
                        actualValue += matrix[r - 1][c];
                    }
                    // Left
                    if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != wrongValue) {
                        actualValue += matrix[r][c - 1];
                    }
                    // Down
                    if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != wrongValue) {
                        actualValue += matrix[r + 1][c];
                    }
                    // Right
                    if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != wrongValue) {
                        actualValue += matrix[r][c + 1];
                    }

                    int[] parameters = new int[3];
                    parameters[0] = r;
                    parameters[1] = c;
                    parameters[2] = actualValue;

                    correctedValues.add(parameters);
                }
            }
        }

        for (int[] params : correctedValues) {
            matrix[params[0]][params[1]] = params[2];
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {

        for (int[] arr : matrix) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length
                && c >= 0 && c < matrix[r].length;
    }


    private static int[][] readMatrix(Scanner scanner) {

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int r = 0; r < size; r++) {
            matrix[r] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
