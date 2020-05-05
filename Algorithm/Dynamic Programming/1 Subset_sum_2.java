package Dynamic_Programming;
//Given an array set[] of length n and an integer "sum", the task is to find the number of subsets with sum equal to "sum".
public class Subset_sum_2
{
    public static void main(String[] args)
    {
        int set[]={3, 34, 4, 12, 5, 2};
        int sum=9;
        int n=set.length;
        System.out.println(CountSubsetSum(set,sum,n));
    }
    static int CountSubsetSum(int[] set,int sum,int n)
    {
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<sum+1;i++)
            dp[0][i]=0;
        for(int i=0;i<n+1;i++)
            dp[i][0]=1;

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(set[i-1]<=j)
                    dp[i][j]=dp[i-1][j-set[i-1]] + dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][sum];
    }
}
