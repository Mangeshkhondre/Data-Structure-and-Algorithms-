package Dynamic_Programming;
//Partition problem is to determine
// whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
public class Even_sum_partition
{
    public static void main(String[] args)
    {
        int set[]={1,5,11,5};
        int n=set.length;
        int sum=0;
        for(int i:set)
            sum+=i;
        if(sum%2!=0)
        {
            System.out.println("false");
            System.exit(0);
        }

        System.out.println(subsetSum(set,sum/2,n));
    }
    static boolean subsetSum(int[] set,int sum,int n)
    {
        boolean dp[][] = new boolean[n+1][sum+1];
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
