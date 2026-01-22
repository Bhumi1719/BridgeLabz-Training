import java.util.*;

public class UnionIntersectionSets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.print("Enter the number of elements in Set1: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of Set1:");
        for(int i=0; i<n1; i++) {
            set1.add(sc.nextInt());
        }

        System.out.print("Enter the number of elements in Set2: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of Set2:");
        for(int i=0; i<n2; i++) {
            set2.add(sc.nextInt());
        }

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        System.out.println("Union of two sets is: " + unionSet);
        System.out.println("Intersection of two setsis: " + intersectionSet);
    }
}
