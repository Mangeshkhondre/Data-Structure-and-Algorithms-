package Dynamic_Programming;

public class Shortest_Superseq_Print
{
    public static void main(String[] args)
    {
        String  X = "HELLO";
        String Y = "GEEK";
        System.out.println(PrintShortestSupersq(X,Y));
    }
    static String PrintShortestSupersq(String X,String Y)
    {
        StringBuilder sb=new StringBuilder();
        int m=X.length();
        int n=Y.length();
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j]= 1 + dp[i-1][j-1];
                else
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int i=m,j=n;
        while(i>0&&j>0)
        {
            if(X.charAt(i-1)==Y.charAt(j-1))
            {
                sb.insert(0, X.charAt(i - 1));
                i--;
                j--;
            }
            else
            {
                if(dp[i-1][j]>dp[i][j-1])
                {
                    sb.insert(0,X.charAt(i-1));
                    i--;
                }
                else
                {
                    sb.insert(0,Y.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0)
        {
            sb.insert(0,X.charAt(i-1));
            i--;
        }
        while(j>0)
        {
            sb.insert(0,Y.charAt(j-1));
            j--;
        }
        return sb.toString();
    }
}
