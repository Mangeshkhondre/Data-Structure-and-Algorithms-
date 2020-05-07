package Dynamic_Programming;

public class Coin_Change_NoOfWays
{
    public static void main(String[] args)
    {
        int coin[]={1,2,3};
        int amount=4;
        System.out.println(CCNoOfWays(coin,amount));
    }
    static int CCNoOfWays(int[] coin,int amount)
    {
        int n=coin.length;
        int[][] dp=new int[n+1][amount+1];

        // if there is no amount , we can create if without selecting any element i.e. with null set.
        for(int i=0;i<n+1;i++)
            dp[i][0]=1;
        // if there is no coins, we cannot form any amount, except 0 amount.
        for(int i=0;i<amount+1;i++)
            dp[0][i]=0;
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
                if(coin[i-1]<=j)// include           // exclude
                    dp[i][j]=  dp[i][j-coin[i-1]] + dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
}
