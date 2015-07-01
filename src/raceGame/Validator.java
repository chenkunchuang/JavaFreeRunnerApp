/**
 * 
 */
package raceGame;

import java.util.Scanner;

/**
 * @author cchuang
 *
 */
public class Validator {
	
	/**
	 * This is to check if the integer is valid or not.  
	 * @param sc: scanner
	 * @param prompt: string to print
	 * @return value
	 */
	public static int getInt(Scanner sc, String prompt)
	    {
	        int i = 0;
	        boolean isValid = false;
	        while (isValid == false)
	        {
	            System.out.print(prompt);
	            if (sc.hasNextInt())
	            {
	                i = sc.nextInt();
	                isValid = true;
	            }
	            else
	            {
	                System.out.println("Error! Invalid integer value. Try again.");
	            }
	            sc.nextLine();  // discard any other data entered on the line
	        }
	        return i;
	    }
	
	/**
	 * This is to check if the input is within the range.  
	 * @param sc : scanner
	 * @param prompt: string to print 
	 * @param min: min value
	 * @param max: max value
	 * @return value
	 */
	 public static int getInt(Scanner sc, String prompt,
			    int min, int max)
			    {
			        int i = 0;
			        boolean isValid = false;
			        while (isValid == false)
			        {
			            i = getInt(sc, prompt);
			            if (i < min)
			                System.out.println(
			                    "Error! Number must be greater than " + min);
			            else if (i > max)
			                System.out.println(
			                    "Error! Number must be less than " + max);
			            else
			                isValid = true;
			        }
			        return i;
			    }
}
