import java.util.*;

public class SetToSortedlist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();

        System.out.print("Enter the number of elements in the set: ");
        int n = sc.nextInt();

        System.out.print("Enter the elements: ");
        for(int i=0; i<n; i++) {
            set.add(sc.nextInt());
        }

        // Converting set to ArrayList
        List<Integer> list = new ArrayList<>(set);

        // Sorting the list
        Collections.sort(list);

        System.out.println("\nSorted List: " + list);
    }
}
