import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class Memberships {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Member> members = new ArrayList<>();

        System.out.print("Enter number of gym members: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for Member " + (i + 1));

            System.out.print("Member Name: ");
            String name = sc.nextLine();

            System.out.print("Expiry Date (YYYY-MM-DD): ");
            String dateInput = sc.nextLine();

            LocalDate expiryDate = LocalDate.parse(dateInput);

            members.add(new Member(name, expiryDate));
        }

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        // Filtering memberships expiring within 30 days
        List<Member> expiringSoon = members.stream()
                .filter(member ->
                        !member.getExpiryDate().isBefore(today) &&
                        !member.getExpiryDate().isAfter(next30Days))
                .collect(Collectors.toList());

        System.out.println("\nMemberships Expiring Within 30 Days:");
        expiringSoon.forEach(System.out::println);
    }
}
