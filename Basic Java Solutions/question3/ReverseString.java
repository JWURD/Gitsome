
package question3;
import java.util.Scanner;
/** Reverses string without using temp variable.
 * @author jwurd
 *@version Aug 14 2017
 */
public class ReverseString {

	public static void main(String[] args){
        System.out.println("Enter string of any length");
		Scanner in = new Scanner(System.in);
		String newString = in.nextLine();
        
		// convert String to char array
		// by using toCharArray
		
		char[] letters = newString.toCharArray();
		
		for(int i = letters.length -1; i >= 0; i --)
			System.out.print(letters[i]);

	}
}