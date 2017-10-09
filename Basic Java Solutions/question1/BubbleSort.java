package question1;
/** sorts given intergers using bubble sort.
 * @author jwurd
 *@version Aug 14 2017
 */

public class BubbleSort {

	static int numbers[] = {1,0,5,6,3,2,3,7,9,8,4};

	/**
	 * Main method runs the application.
	 * @param args
	 */
	public static void main(String [] args){

		bubbleSort(numbers);
		printNewOrder(numbers);

	}
	/**
	 * Sorts integers in acceding order.
	 * @param numbers
	 */
	public static void bubbleSort(int[] numbers){
		boolean swap = true;
		int j = 0;
		int temp;

		while ( swap){
			swap = false;
			j++;

			for(int i = 0; i < numbers.length - j; i++){
				if (numbers[i] > numbers[i+1]) {
					temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					swap = true;
				}
			}
		}
	}
	/**
	 * Prints the new order of sorted integers.
	 * @param numbers
	 */
	public static void printNewOrder(int [] numbers){
		for(int j: numbers){
			System.out.print( j);
		}
	}
}