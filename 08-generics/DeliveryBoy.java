import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {

    public static int rowPizzaBoy;
    public static int colPizzaBoy;

    public static int starRow = 0;
    public static int startCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String row = scanner.nextLine();
            matrix[r] = row.toCharArray();

            int index = row.indexOf('B');

            if (index != -1) {
                starRow = r;
                startCol = index;
            }
        }

        rowPizzaBoy = starRow;
        colPizzaBoy = startCol;

        boolean deliveryInProgress = true;

        while (deliveryInProgress) {
            String direction = scanner.nextLine();

            if (direction.equals("down")) {
                deliveryInProgress = move(matrix, rowPizzaBoy + 1, colPizzaBoy);
            } else if (direction.equals("up")) {
                deliveryInProgress = move(matrix, rowPizzaBoy - 1, colPizzaBoy);
            } else if (direction.equals("left")) {
                deliveryInProgress = move(matrix, rowPizzaBoy, colPizzaBoy - 1);
            } else {
                deliveryInProgress = move(matrix, rowPizzaBoy, colPizzaBoy + 1);
            }

        }

        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean move(char[][] matrix, int nextRow, int nextCol) {

        if (!isInBounds(matrix, nextRow, nextCol)) {
            matrix[starRow][startCol] = ' ';
            System.out.println("The delivery is late. Order is canceled.");
            return false;
        }

        if (matrix[nextRow][nextCol] == '*') {
            return true;
        }

        rowPizzaBoy = nextRow;
        colPizzaBoy = nextCol;

        if (matrix[nextRow][nextCol] == 'P') {
            matrix[nextRow][nextCol] = 'R';
            System.out.println("Pizza is collected. 10 minutes for delivery.");
            return true;
        } else if (matrix[nextRow][nextCol] == 'A') {
            matrix[nextRow][nextCol] = 'P';
            System.out.println("Pizza is delivered on time! Next order...");
            return false;
        }

        if (matrix[nextRow][nextCol] != 'B') {
            matrix[nextRow][nextCol] = '.';
        }
        return true;
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

}
