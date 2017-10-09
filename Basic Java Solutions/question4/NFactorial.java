package question4;

import java.util.Scanner;

/** Determines n Factorial using recursion
 * @author jwurd
 *@version Aug 14 2017
 */
public class NFactorial {

	int i;
	static int fact = 1;


public static void main(String[] args){
	
	System.out.println("Enter a number");
	Scanner in = new Scanner(System.in);
	int number = in.nextInt(); 

	fact = factorial(number);

	System.out.println("Factorial of " + number + " is " + fact);
}
public static int factorial(int n){
	if( n == 0){ //Base Case
		return 1;
	} else
		return(n * factorial(n-1));
}

}