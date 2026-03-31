import java.util.*;

public class ResumeScreening {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<JobRole> jobRoles = new ArrayList<>();

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter candidate name: ");
            String name = sc.nextLine();

            System.out.println("Select Job Role:");
            System.out.println("1. Software Engineer");
            System.out.println("2. Data Scientist");
            System.out.println("3. Product Manager");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            JobRole selectedRole = null;

            switch(choice) {
                case 1 : 
                    selectedRole = new SoftwareEngineer(); 
                    break;
                case 2 :    
                    selectedRole = new DataScientist(); 
                    break;
                case 3 : 
                    selectedRole = new ProductManager(); 
                    break;
                default:
                    System.out.println("Invalid choice! Skipping candidate.");
                    continue;
            }

            Resume<?> resume = ScreeningSystem.generateResume(name, selectedRole);
            resume.display();

            jobRoles.add(selectedRole);
        }

        // Batch screening all candidates at once
        ScreeningSystem.screenAllResumes(jobRoles);
    }
}
