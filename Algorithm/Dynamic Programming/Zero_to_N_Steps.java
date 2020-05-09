package Dynamic_Programming;
/* geeksforgeeks : Minimum Operations
You are given a number N. You have to find the number of operations required to reach N from 0.
You have 2 operations available:
Double the number
Add one to the number
Input  : N = 8
        Output : 4
        0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
*/
public class Zero_to_N_Steps
{
    public static void main(String[] args)
    {
        int n=7;
        System.out.println(RecursiveSolution(n));
        System.out.println(dpSolution(n));
    }
    static int RecursiveSolution(int n)
    {
        if(n==0)
            return 0;
        if(n%2==0)
            return 1+RecursiveSolution(n/2);
        else
            return 1+RecursiveSolution(n-1);
    }
    static int dpSolution(int n)
    {
        int[] dp=new int[n+1];
        for(int i=0;i<=3;i++)
            dp[i]=i;
        for(int i=4;i<n+1;i++)
        {
            if(i%2==0)
                dp[i]=1+dp[i/2];
            else
                dp[i]=1+dp[i-1];
        }
        return dp[n];
    }
}
