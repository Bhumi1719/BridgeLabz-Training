import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JobPortal portal = new JobPortal();

        while(true) {

            System.out.println("\nJob Portal");
            System.out.println("1. Add Resume");
            System.out.println("2. Shortlist Resumes");
            System.out.println("3. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:

                        System.out.print("Enter candidate name: ");
                        String name = sc.nextLine();

                        System.out.print(
                            "Enter skills (comma separated): ");
                        String[] skillsArray = sc.nextLine().split(",");

                        Set<String> skills = new HashSet<>();

                        for(String s : skillsArray) {
                            skills.add(s.trim().toLowerCase());
                        }

                        Resume resume = new Resume(name, skills);

                        portal.addResume(resume);

                        System.out.println("Resume added!");
                        break;

                    case 2:

                        System.out.print(
                            "Enter required skills (comma separated): ");

                        String[] reqArray = sc.nextLine().split(",");

                        Set<String> requiredSkills = new HashSet<>();

                        for (String s : reqArray) {
                            requiredSkills.add(s.trim().toLowerCase());
                        }

                        portal.shortlistResumes(requiredSkills);
                        break;

                    case 3:
                        System.out.println("Exited");
                        System.exit(0);
                }

            } catch (InvalidResumeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
