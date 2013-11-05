import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class binarySearch
{
	int answer;
	public static int middle(int a, int b)
	{
		int m;
		m=(a+b)/2;
		return m;
	}
	public static void main(String[] args)
    {
		int answer;
		binarySearch(1,1000, 15);
        //int key = 77; 
    	/* int answer;
        int[ ] num = new int [6];
        // Fill the array
    	Scanner in = new Scanner(System.in);
    	Scanner in2 = new Scanner(System.in);
    	
    	System.out.println("Pick a number: ");
    	int key = in2.nextInt();
    	 	
        for (int i = 0; i < 6; i++)
        {
        	int x = 0;
        	System.out.println("Please enter number to guess:"); 
        	num[ i ]=in.nextInt();
        }
        Arrays.sort(num);
        //The binary search method   
        System.out.println (binarySearch (num, key));*/
		
		
		
        
    }

   public static int binarySearch(int i, int j, int answer)
   {
	   Scanner in = new Scanner(System.in);
	   int m;
	   m=middle(i,j);
	   System.out.println("Is the number: ?");
	   answer = in.nextInt();
	   if (answer==1) 
		   {
		   	System.out.println("OK!!");
		   }
	   
	   else
	   {
		   System.out.println("Is the number smaller then?");
		   answer = in.nextInt();
			
			if(answer==1)
				binarySearch(i, m-1, answer);
			else
				binarySearch(m+1, j, answer);	
				
		
	   }
	   return -1;
       //int position;
       //int comparisonCount = 1;    // counting the number of comparisons (optional)

     // To start, find the subscript of the middle position.
     //position = ( lowerbound + upperbound) / 2;
       /*int lo = 0;
       int hi = array.length-1;
       while (lo <= hi) {
           
    	   int mid = lo + (hi - lo) / 2;
           //if (mid==)
           if      (key < array[mid]) hi = mid - 1;
           else if (key > array[mid]) lo = mid + 1;
           else return mid;
       }
       return -1;*/
     /*while((lowerbound <= upperbound))
     {
         comparisonCount++;
         if (array[position] > key)             // If the number is > key, ..
         {                                              // decrease position by one. 
              upperbound = position - 1;   
         }                                                             
              else                                                   
        {                                                        
              lowerbound = position + 1;    // Else, increase position by one. 
        }
       position = (lowerbound + upperbound) / 2;
     }
     if (lowerbound <= upperbound)
     {
           System.out.println("The number was found in array subscript " + position + " and the key is " + key);
           System.out.println("The binary search found the number after " + comparisonCount +
                 " comparisons.");
           // printing the number of comparisons is optional
     }
     else
          System.out.println("Sorry, the number is not in this array.  The binary search made "
                 +comparisonCount  + " comparisons.");*/
  }

}