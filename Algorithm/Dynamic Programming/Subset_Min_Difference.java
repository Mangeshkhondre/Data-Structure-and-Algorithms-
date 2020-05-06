package Dynamic_Programming;
//Partition a set into two subsets such that the difference of subset sums is minimum
public class Subset_Min_Difference
{
    public static void main(String[] args)
    {
        int set[] = {1,2,7};
        int n=set.length;
        int totalSum=0;
        for(int i:set)
            totalSum+=i;
        System.out.println(minSubsetDiff(set,n,totalSum));
    }
    static int minSubsetDiff(int[] set,int n,int totalSum)
    {
        boolean[][] dp=new boolean[n+1][totalSum+1];
        for(int i=0;i<totalSum;i++)
            dp[0][i]=false;
        for(int i=0;i<n+1;i++)
            dp[i][0]=true;


        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<totalSum+1;j++)
            {
                if(set[i-1]<=j)
                    dp[i][j]=dp[i-1][j-set[i-1]] | dp[i][j] ;
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        int min=Integer.MAX_VALUE;

        for(int j=totalSum/2;j>=0;j--)
        {
            if(dp[n][j]==true)
            {
                min=totalSum-2*j;
                break;
            }
        }
        return min;
    }
}
