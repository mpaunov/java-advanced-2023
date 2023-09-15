import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2SubMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] maxSubMatrix = new int[2][2];

        int finalSum = Integer.MIN_VALUE;

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {

                int currentElement = matrix[r][c];
                int right = matrix[r][c + 1];
                int below = matrix[r + 1][c];
                int rightBelow = matrix[r + 1][c + 1];

                int sum = currentElement + right + below + rightBelow;
                if (finalSum < sum) {
                    finalSum = sum;
                    maxSubMatrix[0][0] = currentElement;
                    maxSubMatrix[0][1] = right;
                    maxSubMatrix[1][0] = below;
                    maxSubMatrix[1][1] = rightBelow;
                }
            }
        }

        System.out.println(maxSubMatrix[0][0] + " " + maxSubMatrix[0][1]);
        System.out.println(maxSubMatrix[1][0] + " " + maxSubMatrix[1][1]);

        System.out.println(finalSum);

    }

}
