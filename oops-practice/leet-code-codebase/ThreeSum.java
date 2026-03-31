import java.util.*; 
public class ThreeSum {
	
	// Creating a method to find indices of sum = 0
	public static List<List<Integer>> threeSum(int[] nums) {
		
	       List<List<Integer>> res = new ArrayList<>();
	        Arrays.sort(nums);

	        for (int i = 0; i < nums.length; i++) {
	            if (i > 0 && nums[i] == nums[i-1]) {
	                continue;
	            }
	            int j = i + 1;
	            int k = nums.length - 1;
	            while (j < k) {
	                int total = nums[i] + nums[j] + nums[k];
	                if (total > 0) {
	                    k--;
	                } else if (total < 0) {
	                    j++;
	                } else {
	                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
	                    j++;
	                    while (nums[j] == nums[j-1] && j < k) {
	                        j++;
	                    }
	                }
	            }
	        }
	        return res; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> result = threeSum(nums);

        System.out.println("Triplets with sum = 0:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
	}

}
