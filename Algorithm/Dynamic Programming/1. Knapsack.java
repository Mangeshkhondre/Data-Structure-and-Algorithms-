package Dynamic_Programming;
class Knapsack
{
    public static void main(String[] args)
    {
        int n=3;
        int W=4;
        int val[]={1,2,3};
        int wt[]={4,5,1};

        System.out.println("Maximum Profit = "+knapsack(val,wt,W,n));

    }
/*  Method 1 - Simple Recursion , but takes more time.
    public static int knapsack(int val[],int wt[],int W,int n)
    {
        //Base Condition
        if(n==0||W==0)
            return 0;

        //Choice
        if(wt[n-1] <= W)
            return Math.max( val[n-1]+knapsack(val,wt,W-wt[n-1],n-1)  ,knapsack(val,wt,W,n-1) );
        else
            return knapsack(val,wt,W,n-1);
    }
*/
/*  Method - 2 : Memoization : Save the values when calculated for first time..
    public static int knapsack(int val[],int wt[],int W,int n)
    {
        // Tm[][] for memoization
        int Tm[][]=new int[n+1][W+1];
        // Initialize all Matrix to "-1".
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<W+1;j++)
            {
                Tm[i][j]=-1;
            }
        }
        //Base Condition
        if(n==0||W==0)
            return 0;
        // Check if value already calculated..
        if(Tm[n][W]!=-1)
            return Tm[n][W];
        // if not calculated, calculate and save...
        if(wt[n-1]<=W)
            return Tm[n][W]=Math.max(val[n-1]+knapsack(val,wt,W-wt[n-1],n-1),knapsack(val,wt,W,n-1));
        else
            return Tm[n][W]=knapsack(val,wt,W,n-1);
    }
*/

    // Method - 3 : Top-Down (dp[][]) : Here we convert recursive calls into iterative calls.
    public static int knapsack(int[] val,int[] wt,int W,int n)
    {
        int dp[][] = new int[n + 1][W + 1];
        //Conversion of base condition
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < W + 1; j++)
            {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }

        // Choice
        for (int i = 1; i < n + 1; i++)
        {
            for (int j = 1; j < W + 1; j++)
            {
                if(wt[i-1]<=j)
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }

        return dp[n][W];
    }
}
