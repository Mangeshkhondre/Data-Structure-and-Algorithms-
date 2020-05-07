package Dynamic_Programming;
// Variation of "Coin change - minimun no. of coins"
/*Given a number N. You need to write a program to print the minimum number of squares of this number that sums to N.
  For Example: If N = 100 , N can be expressed as (10*10) and also as (5*5 + 5*5 + 5*5 + 5*5
  but the output will be 1 as minimum number of square is 1 , i.e (10*10).*/

public class Min_NoOf_Squares
{
    public static void main(String[] args)
    {
        int v=6;
        // if number is perfect square (25) then minimum is always 1 (5*5)
        if(Math.sqrt(v)==nearest_perfect_sq(v))
        {
            System.out.println(1);
            // use "continue" if you are passing multiple values in same program execution.
            System.exit(0);
        }
        // if number is <= 3 , then we need that much times 1*1. no=2. 1*1+1*1=> (2)
        if(v<=3)
        {
            System.out.println(v);
            System.exit(0);
        }

        System.out.println(MinSquares(v));
    }
    static int nearest_perfect_sq(int n)
    {
        if(n<=3)
            return 1;
        double sq=Math.sqrt(n);
        if(Math.floor(sq)!=sq)
            return nearest_perfect_sq(n-1);
        else
            return (int)sq;
    }
    static int MinSquares(int v)
    {
        int no_of_row=nearest_perfect_sq(v);
        int[][] dp=new int[no_of_row+1][v+1];

        for(int i=0;i<v+1;i++)
            dp[0][i]=Integer.MAX_VALUE-1;
        for(int i=1;i<no_of_row+1;i++)
            dp[i][0]=0;

        for(int i=1;i<no_of_row+1;i++)
        {
            for(int j=1;j<v+1;j++)
            {
                if (i*i<= j)
                    dp[i][j] = Math.min(1 + dp[i][j - i*i], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[no_of_row][v];
    }

}
