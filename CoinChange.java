class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount];
        if(amount == 0)
            return 0;

        coin(coins,amount,dp);

        if(dp[amount-1] != 0)
            return dp[amount-1];
        else
            return -1;
    }

    public static int coin(int [] coins, int amount, int[]dp){
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;


        if(dp[amount-1] != 0)
            return dp[amount-1];

        int min = Integer.MAX_VALUE;

        for(int val : coins){
            int c =  coin(coins, amount-val, dp);
            if(c>=0 && c < min){
                min = c + 1;
            }
        }

        dp[amount-1] = (min == Integer.MAX_VALUE) ?-1: min;
        return dp[amount-1];

    }

    public static void main(String[] args) {
        int [] coins =new int[]{1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins,amount));
    }
}