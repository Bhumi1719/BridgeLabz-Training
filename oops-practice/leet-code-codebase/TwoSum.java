import java.util.*; 

public class TwoSum {
	
	// Creating a method to calculate sum
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop for storing values
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        // Find complement
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{-1, -1};
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter array elements:");
        for(int i=0; i<size; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        if (result[0] != -1) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No solution found");
        }

	}

}
