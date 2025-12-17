import java.util.*;
public class inter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	// Takes input
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            arr2[i] = sc.nextInt();
        }

	// Finding Intersection of two arrays and storing it in variable
        ArrayList<Integer> ls = findIntersection(arr1, arr2);
	//Sorting the result
        Collections.sort(ls);
        System.out.println(ls);
    }

    
    // Method to find intersection of two arrays
    public static ArrayList<Integer> findIntersection(int []arr1, int []arr2){
	// HashMap to store frequency of elements of arr1
        Map<Integer, Integer> mp = new HashMap<>();

	// List to store intersection elements
        ArrayList<Integer> res = new ArrayList<>();

	// Store frequency of each element of arr1
        for(int num : arr1){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

	// Check elements of arr2-if exists in map and frequency > 0 then add to result and decrease frequency by 1
        for(int num : arr2){
            if(mp.containsKey(num) && mp.get(num) > 0){
                res.add(num);
                mp.put(num, mp.get(num)-1);
            }
        }
        return res;    
    }
}
