import java.util.*;

class ScreeningSystem {

    public static void screenAllResumes(List<? extends JobRole> resumes) {
        System.out.println("\nScreening all resumes in the system:");
        for(JobRole role : resumes) {
            role.screenResume();
        }
    }

    // Generic method to create Resume dynamically
    public static <T extends JobRole> Resume<T> generateResume(String name, T role) {
        System.out.println("Generating resume for " + name + " applying as " + role.getRoleName());
        return new Resume<>(name, role);
    }
}
