package Dynamic_Programming;
/*Given two strings str1 and str2,
  find the length of the smallest string which has both, str1 and str2 as its sub-sequences.*/
public class Shortest_Superseq
{
    public static void main(String[] args)
    {
        String X="abcd";
        String Y="abx";
        // answer = " abxcd "
        // we just take one count for repeated char in both string, like a & b only once. and others as it is.
        // so len(x) + len(y) - len(longest common subsequence)
        //    abcd + abx - ab => 4+3-2=5
        System.out.println(LengthOfShortestSupersq(X,Y));
    }
    static int LengthOfShortestSupersq(String X,String Y)
    {
        int result;

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
        result=m+n-dp[m][n];
        return result;
    }
}
