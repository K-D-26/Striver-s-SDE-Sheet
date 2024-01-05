class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.sort(coins);
        
        for (int amt = 1; amt <= amount; amt++) {
            dp[amt] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amt - coin < 0) {
                    break;
                }
                
                if (dp[amt - coin] != Integer.MAX_VALUE) {
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
                }
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        
        
        // Greedy solution:
        // This won't work as the coins array contains custom values,
        // these values are not the general values.
        
        /*
        
        int coinsReq = 0;
        Arrays.sort(coins);
        int i = coins.length-1;
        
        while(amount > 0 && i>= 0) {
            if(coins[i] > amount) {
                i--;
            }
            else {
                amount -= coins[i];
                coinsReq++;
            }
        }
        
        return amount == 0 ? coinsReq : -1;
        
        */
    }
}