import java.util.*;

public class GreedyAlgorithms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {

        int[] sortedCoins = Arrays.stream(coins).sorted().toArray();

        int index = sortedCoins.length - 1;

        HashMap<Integer, Integer> countedCoins = new LinkedHashMap<>();

        while (targetSum != 0 && index >= 0) {
            int coin = sortedCoins[index--];
            int coinsCount = targetSum / coin;
            targetSum = targetSum % coin;
            if (coinsCount != 0) {
                countedCoins.put(coin, coinsCount);
            }
        }

        return countedCoins;
    }
}
