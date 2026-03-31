import java.util.*;
public class ExistOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	//Takes input
        int t = sc.nextInt();
        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = sc.nextInt();
            }
		
	    //Creating hashset and storing the elements in set
            Set<Integer> set = new HashSet<>();
            for(int num : arr){
                set.add(num);
            }
            int q = sc.nextInt();
	    //For each query reads element and check if element exists or not
            for(int j=0; j<q; j++){
                int query = sc.nextInt();
                if(set.contains(query)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }     
            }
        }  
        sc.close();  
    }
}
