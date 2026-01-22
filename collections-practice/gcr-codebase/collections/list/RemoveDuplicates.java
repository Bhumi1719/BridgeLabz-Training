import java.util.*;

public class RemoveDuplicates {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int x : list) {
            if(!seen.contains(x)) {
                seen.add(x);
                result.add(x);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int size = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        System.out.print("Enter the elements: ");
        for(int i=0; i<size; i++) {
            list.add(sc.nextInt());
        }

        List<Integer> uniqueList = removeDuplicates(list);

        System.out.println("\nAfter Removing Duplicates the list is: " + uniqueList);
    }
}
