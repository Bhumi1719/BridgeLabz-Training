import java.util.*;
import java.util.stream.*;

public class InsuranceClaim {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Claim> claims = new ArrayList<>();

        System.out.print("Enter number of claims: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for(int i=0; i<n; i++) {
            System.out.println("\nEnter details for Claim " + (i + 1));

            System.out.print("Claim Type (Health/Car/Home etc.): ");
            String type = sc.nextLine();

            System.out.print("Claim Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); 

            claims.add(new Claim(type, amount));
        }

        Map<String, Double> averageClaims = claims.stream().collect(Collectors.groupingBy(Claim::getClaimType, Collectors.averagingDouble(Claim::getAmount)));

        System.out.println("\nAverage Claim Amount for Each Type:");
        averageClaims.forEach((type, avg) -> System.out.println(type + " : " + avg));
    }
}
