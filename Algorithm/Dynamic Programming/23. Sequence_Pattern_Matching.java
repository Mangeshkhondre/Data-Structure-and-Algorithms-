package Dynamic_Programming;

public class Sequence_Pattern_Matching
{
    public static void main(String[] args)
    {
        String X="AXY";
        String Y="ABXCYZ";
        int m=X.length();
        int n=Y.length();
        String ans=PrintLCS(X,Y,m,n);
        boolean result=(X.equals(ans))?true:false;
        System.out.println(result);
    }
    static String  PrintLCS(String X, String Y, int m, int n)
    {
        int dp[][] = new int[m + 1][n + 1];
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
            {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] =dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);;
            }
        }
        int i=m,j=n;
        while(i>0 && j>0)
        {
            if(X.charAt(i-1)==Y.charAt(j-1))
            {
                sb.insert(0,X.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if(dp[i-1][j]>dp[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return sb.toString();
    }
}
