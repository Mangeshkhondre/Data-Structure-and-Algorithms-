package Dynamic_Programming;

public class Longest_Palindromic_subsq
{
    public static void main(String[] args)
    {
        String X="agbcjba";
        System.out.println(LPS(X));
    }
    static int LPS(String X)
    {
        String Y=new StringBuilder(X).reverse().toString();
        int m=X.length();
        int n=Y.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
