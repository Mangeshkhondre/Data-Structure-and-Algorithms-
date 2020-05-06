package Dynamic_Programming;

public class Unbounded_Knapsack {
    public static void main(String[] args) {
        int N = 3;
        int W = 45;
        int[] wt = {12, 20, 15};
        int[] val = {40, 60, 50};
        System.out.println(ub_ks(wt, val, N, W));
    }

    static int ub_ks(int[] wt, int[] val, int n, int W)
    {
/*        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][W];
*/
        int[] dp=new int[W+1];
        for(int i=0;i<n;i++)
        {
            for(int j=wt[i];j<=W;j++)
            {
                dp[j]=Math.max( val[i]+dp[j-wt[i]], dp[i]);
            }
        }
        return dp[W];
    }

}
