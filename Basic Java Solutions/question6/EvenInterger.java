
package question6;

import java.util.Scanner;

/** Determines if given number is odd or even.
 * @author jwurd
 *@version Aug 14 2017
 */
public class EvenInterger {
	/**
	 *  Determines if number is even by using division.
	 * @param number
	 */
	public static void isEven(int number){
		
		if( number % 2 == 0){
			System.out.print("Even");
		}
		else System.out.print("Odd");
			}
	public static void main(String []args){
     int number;
		Scanner in = new Scanner(System.in);

		// User Prompt to enter number check if even.
		System.out.print("Enter a number");
		// scans user input for number entered.
		number = in.nextInt();
		isEven(number);
	  
		in.close();
	
}
}
