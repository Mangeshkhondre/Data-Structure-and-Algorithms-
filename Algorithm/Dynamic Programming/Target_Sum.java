package Dynamic_Programming;
// You are given a set and a target, S.
// Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
// Find out how many ways to assign symbols to make sum of integers equal to target S.


public class Target_Sum
{
    public static void main(String[] args)
    {
        int set[] = {1,1,2,3};
        int S=1;
        // Hint -
        // eg. +1-1-2+3 = 1
        // => (+1+3)+(-1-2)=1
        // => (+1+3) - (+1+2) = 1
        // Hence problem becomes Subset_Difference
        int n=set.length;
        int totalSum=0;
        for(int i:set)
            totalSum+=i;
        int reqSum=(S+totalSum)/2;
        System.out.println(CountSubsetDiff(set,n,reqSum));
    }
    static int CountSubsetDiff(int[] set,int n,int sum)
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
