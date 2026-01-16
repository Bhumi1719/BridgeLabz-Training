import java.util.*;
public class MaxFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	//Takes input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

	//HashMap to store frequency of all elements
        Map<Integer, Integer> map = new HashMap<>();

	//Variable to store maximum frequency found
        int maxfr = 0;

	//Variable to store element with maximum frequency
        int mostFreno = arr[0];
        for(int num : arr){

	    //Increasing frequency of current number
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);

	    //Check if current frequency is greater than max frequency
            if(freq > maxfr){
                maxfr = freq;
                mostFreno = num;
            }
        }
        System.out.println(mostFreno);    
    }
}
