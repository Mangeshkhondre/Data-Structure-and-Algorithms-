package Dynamic_Programming;
// Count no. of subsets which have difference equal to given "diff"
public class Subset_Difference
{
    public static void main(String[] args)
    {
        int set[] = {1,1,2,3};
        int diff=1;

        // we have to count no. of subsets having sum, s1 = (diff + totalSum) / 2
        // other subset will automatically sum to "totalSum-s1".
        // which will give difference "diff"

        int n=set.length;
        int totalSum=0;
        for(int i:set)
            totalSum+=i;
        int reqSum=(diff+totalSum)/2;
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
