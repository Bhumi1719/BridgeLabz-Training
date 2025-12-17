import java.util.Arrays;

public class move_zeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12}; 

	//Sort the array  
        Arrays.sort(arr);

	//Finding index of first non-zero element
        int k = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                k = i;
                break;
            }
        }
        rev(arr, k, arr.length-1); //Reverse non-zero part
        rev(arr, 0, arr.length-1); //Reverse whole array
        System.out.println(Arrays.toString(arr));
    }

    //Method to reverse part of array
    public static void rev(int[] arr, int p1, int p2){
        while(p1<p2){
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }
}
