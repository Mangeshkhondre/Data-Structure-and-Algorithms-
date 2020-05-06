package Dynamic_Programming;

public class Rod_Cutting
{
    public static void main(String[] args)
    {
        int N=8;
        int[] price={1,5,8,9,10,17,17,20};
        System.out.println(MaxRodCuttingPrice(price,N));

    }
    static int MaxRodCuttingPrice(int[] price,int Length)
    {
        int n = price.length;
        int[][] dp=new int[n+1][Length+1];

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<Length+1;j++)
            {
                if(i<=j)
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-i],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][Length];
    }
}
