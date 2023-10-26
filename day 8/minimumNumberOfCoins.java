import java.util.*;

public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

        List<Integer> ans = new ArrayList<>();
        int i = 8;

        while (n > 0) {
            if (coins[i] <= n) {
                ans.add(coins[i]);
                n -= coins[i];
            }
            else {
                i--;
            }
        }

        return ans;
    }
}