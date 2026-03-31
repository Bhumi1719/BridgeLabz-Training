import java.util.*;

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] numbers) {
		 HashSet<Integer> set = new HashSet<>();
		 
		 // Loop for adding the elements to the set
	     for(int i=0; i<numbers.length; i++){
	         set.add(numbers[i]);
	     }

	     // Converting the set to the list
	     List<Integer> sorted = new ArrayList<>(set);
	        
	     Collections.sort(sorted); // Sorting the list
	        
	     int size = sorted.size();
	     
	     int j=0;
	     for(int num : sorted){
	         numbers[j++] = num;
	     }
	        
	     return size;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of array: ");
		int size = sc.nextInt();
		
		// Creating an array to store the elements
		int[] numbers = new int[size];
		
		System.out.println("Enter the elements of array: ");
		for(int i=0; i<size; i++) {
			numbers[i] = sc.nextInt();
		}
		
		System.out.println("The size of the array after removing the duplicate elements is: " + removeDuplicates(numbers));
	}

}
