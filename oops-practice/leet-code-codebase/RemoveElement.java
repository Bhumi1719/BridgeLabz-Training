import java.util.*; 

public class RemoveElement {

	public static int findElementsWithoutTarget(int[] arr , int val){
        int num = 0 ; 
        for(int i=0; i<arr.length; i++){
            if(arr[i] != val){
                arr[num] = arr[i];
                num++;
            }
        }
        return num; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of array: ");
		int size = sc.nextInt();
		
		// Creating an array to store the elements
		int[] numbers = new int[size];
		
		System.out.println("Enter the elements in array: ");
		for(int i=0; i<size; i++) {
			numbers[i] = sc.nextInt();
		}
		
		System.out.print("Enter the target element: ");
		int target = sc.nextInt();
		
		System.out.println("The number of elements without the target element is: " + findElementsWithoutTarget(numbers, target));
		
	}

}

