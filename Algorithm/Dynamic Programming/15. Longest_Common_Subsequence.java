package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Common_Subsequence
{
    public static void main(String[] args)
    {
        String X = "acajhh";
        String Y = "aabc";


        int m=X.length();
        int n=Y.length();

        // Using Recursion
        //System.out.println(LCSRecursive(X,Y,m,n));

        // Using Memoization( bottom -up)
        //System.out.println(LCSMemoization(X,Y,m,n));

        // Using TopDown approach
        System.out.println(LCSTopDown(X,Y,m,n));
    }
    static int LCSRecursive(String X, String Y, int m, int n)
    {
        // Base Condition
        if(m==0 || n==0)
            return 0;

        // Choice code
        if(X.charAt(m-1)==Y.charAt(n-1))
            return 1+ LCSRecursive(X,Y,m-1,n-1);
        else
            return Math.max(LCSRecursive(X,Y,m,n-1), LCSRecursive(X,Y,m-1,n));
    }
    static int LCSMemoization(String X,String Y,int m,int n)
    {
        int[][] dp=new int[m+1][n+1];
        for(int[] x:dp)
            Arrays.fill(x,-1);

        if(m==0 || n==0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];

        if(X.charAt(m-1)==Y.charAt(n-1))
            return dp[m][n]= 1+ LCSMemoization(X,Y,m-1,n-1);
        else
            return dp[m][n]= Math.max(LCSMemoization(X,Y,m-1,n),LCSMemoization(X,Y,m,n-1));
    }
    static int LCSTopDown(String X,String Y,int m,int n)
    {
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
