package Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

// Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
// The task is to remove/delete and insert minimum number of characters from/in str1
// so as to transform it into str2. It could be possible that the same character needs
// to be removed/deleted from one point of str1 and inserted to some another point
public class LCS_min_del_insert
{
    public static void main(String[] args)
    {
        String X="heap";
        String Y="pea";
        // delete h,p and insert p => 2+1 => 3
        int m=X.length();
        int n=Y.length();
        List l1=new ArrayList<Integer>();
        l1=NoOfOp(X,Y,m,n);

        System.out.println("No. of Deletions = "+l1.get(0));
        System.out.println("No. of Insertions= "+l1.get(1));
        System.out.println("Total Operations = "+l1.get(2));

    }
    static List NoOfOp(String X,String Y,int m,int n)
    {
        List l1=new ArrayList<Integer>();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int lenOfLCS=dp[m][n];
        int noOfDeletions = m-lenOfLCS;
        l1.add(noOfDeletions);
        int noOfInsertions= n-lenOfLCS;
        l1.add(noOfInsertions);
        int totalOps = noOfDeletions + noOfInsertions;
        l1.add(totalOps);
        return l1;
        // return m+n-2*dp[m][n];
    }
}
