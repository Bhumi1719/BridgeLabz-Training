import java.util.*;

public class EduResults {

    public static Student[] merge(Student[] a, Student[] b) {

        Student[] result = new Student[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < a.length && j < b.length) {
            if(a[i].marks > b[j].marks) {
                result[k++] = a[i++];
            } else { 
                result[k++] = b[j++];
            }
        }

        while(i < a.length) {
            result[k++] = a[i++];
        }

        while(j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static Student[] mergeAll(Student[][] lists, int left, int right) {
        if(left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;

        Student[] l1 = mergeAll(lists, left, mid);
        Student[] l2 = mergeAll(lists, mid + 1, right);

        return merge(l1, l2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of districts: ");
        int d = sc.nextInt();

        Student[][] districts = new Student[d][];

        for(int i=0; i<d; i++) {
            System.out.print("Enter number of students in district " + (i + 1) + ": ");
            int n = sc.nextInt();
            districts[i] = new Student[n];

            System.out.println("\nEnter students in sorted order (by marks desc):");
            for(int j=0; j<n; j++) {
                System.out.print("Name: ");
                String name = sc.next();
                System.out.print("Marks: ");
                int marks = sc.nextInt();
                districts[i][j] = new Student(name, marks);
            }
        }

        Student[] finalRank = mergeAll(districts, 0, d - 1);

        System.out.println("\nFinal State Wise Rank List:");
        for(Student s : finalRank) {
            System.out.println(s.name + " - " + s.marks);
        }
    }
}
