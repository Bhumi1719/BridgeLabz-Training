import java.util.*;

public class JobPortal {

    private List<Resume> resumes = new ArrayList<>();

    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    public void shortlistResumes(Set<String> requiredSkills) {

        Collections.sort(resumes, new ResumeComparator(requiredSkills));

        System.out.println("\nShortlisted Resumes:");

        for(Resume r : resumes) {

            int matches = 0;

            for(String skill : r.getSkills()) {
                if(requiredSkills.contains(skill.toLowerCase())) {
                    matches++;
                }
            }

            System.out.println(r.getCandidateName() + " -> Matching Skills: " + matches);
        }
    }
}
