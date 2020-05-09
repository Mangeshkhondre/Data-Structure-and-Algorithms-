package Dynamic_Programming;

public class Longes_Common_Substring
{
    public static void main(String[] args)
    {
        String X="aaaa";
        String Y="aa";
        int m=X.length();
        int n=Y.length();
        System.out.println(LCStrTopDown(X,Y,m,n));
    }
    static int LCStrTopDown(String X,String Y,int m,int n)
    {
        int dp[][]=new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=0;
            }
        }
        int max=0;
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<n+1;j++)
            {
                max=Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
