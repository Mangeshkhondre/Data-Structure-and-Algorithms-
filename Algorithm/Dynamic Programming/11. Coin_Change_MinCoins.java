package Dynamic_Programming;
public class Coin_Change_MinCoins
{
    public static void main(String[] args)
    {
        int[] coins={3,5};
        int amount=4;
        System.out.println(CCMinCoins(coins,amount));
    }
    static int CCMinCoins(int[] coins,int amount)
    {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        for(int i=0;i<amount+1;i++)
            dp[0][i]=Integer.MAX_VALUE-1;
        for(int i=1;i<n+1;i++)
            dp[i][0]=0;

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if (coins[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        // if there it is not possible to form that amount in any way, we will return -1.
        // eg: amount 4 , coins[3,5]
        int result = ( dp[n][amount]==Integer.MAX_VALUE-1) ? -1 : dp[n][amount];
        return result;
    }
}

