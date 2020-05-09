package Dynamic_Programming;
// Geeksforgeeks : Count all possible paths from top left to bottom right
// The task is to count all the possible paths from top left to bottom right of a mXn matrix
// with the constraints that from each cell you can either move only to right or down.
public class NoOfWaysTopLeft2BottomRight
{
    public static void main(String[] args)
    {
        int m=3;
        int n=3;

        System.out.println(CountWays(m,n));
    }
    static int CountWays(int m,int n)
    {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++)
            dp[i][0]=1;
        for(int i=0;i<n;i++)
            dp[0][i]=1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        return dp[m-1][n-1];
    }
}
