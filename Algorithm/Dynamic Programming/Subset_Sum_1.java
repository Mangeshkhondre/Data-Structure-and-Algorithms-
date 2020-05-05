// Given a set of non-negative integers, and a value sum,
// determine if there is a subset of the given set with sum equal to given sum.
package Dynamic_Programming;
public class Subset_Sum_1
{
    public static void main(String[] args)
    {
        int set[]={3, 34, 4, 12, 5, 2};
        int sum=9;
        int n=set.length;
       // boolean ans= (sum==subsetSum(set,sum,n)) ;
       // System.out.println(ans);
        System.out.println(subsetSum(set,sum,n));
    }
/*
    USING int dp[][]
    public static int subsetSum(int[] set,int sum,int n)
    {
        int[][] dp=new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<sum+1;j++)
            {
               if(i==0||j==0)
                   dp[i][j]=0;
            }
//        if(set[n-1]<=sum)
//            return Math.max(set[n-1]+subsetSum(set,sum-set[n-1],n-1), subsetSum(set,sum,n-1));
//        else
//            return subsetSum(set,sum,n-1);
        for(int i=1;i<n+1;i++)
            for(int j=1;j<sum+1;j++)
            {
                if(set[i-1]<=j)
                    dp[i][j]=Math.max(set[i-1]+dp[i-1][j-set[i-1]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        return dp[n][sum];
    }


 */
    //USING boolean dp[][]
    public static boolean subsetSum(int[] set,int sum,int n)
    {
        boolean dp[][]=new boolean[n+1][sum+1];

        // if there are no elements given , then return false as there will be no such subset.
        for(int i=0;i<sum+1;i++)
            dp[0][i]=false;

        // if given sum == 0 , then there will be 1 empty subset fulfilling given condition.
        for(int i=0;i<n+1;i++)
            dp[i][0]=true;

        // if you swap the position of above initialization then uncomment following line.
        //dp[0][0]=true;

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(set[i-1]<=j)
                    dp[i][j]= dp[i-1][j-set[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
