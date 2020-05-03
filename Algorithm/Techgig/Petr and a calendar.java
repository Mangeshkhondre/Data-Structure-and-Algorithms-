
// Petr wants to make a calendar for current month. For this purpose he draws a table in which columns correspond to weeks
// (a week is seven consequent days from Monday to Sunday), rows correspond to weekdays, and cells contain dates. 
// For example, a calendar for January 2017 should look like on the picture:

// Petr wants to know how many columns his table should have given the month and the weekday of the first date of that month? 
// Assume that the year is non-leap.
// Input Format- You will be given a function with two integers m and d as arguments.
// Constraints- 1 < = m < = 12, 1 < = d < = 7
// Output Format-You need to return single integer: the number of columns the table should have..
// Sample TestCase 1
// Input
// 1
// 7
// Output
// 6

// JAVA Programs -

import java.io.*;
import java.util.*;
public class CandidateCode 
{
    public static void main(String args[] ) throws Exception
    {
         Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int d=sc.nextInt();
        //if month is february
        if (m == 2)
        {
                if (d == 1) 
                {
                    System.out.print("4");
                    return;
                }
                else
                {
                    System.out.print("5");
                    return;
                }
        }
        // months with 31 days
        else if ((m == 1) || (m == 3) || (m == 5) || (m == 7) || (m == 8) || (m == 10) || (m == 12)) 
        {
                if (d <= 5)
                {
                    System.out.print("5");
                    return;
                } 
                else 
                {
                    System.out.print("6");
                    return;
                }
        }
        // months with 30 days
        else 
        {
                if (d <= 6)
                {
                    System.out.print("5");
                    return;
                }
                else
                {
                    System.out.print("6");
                    return;
                }            
        }
    }
}
