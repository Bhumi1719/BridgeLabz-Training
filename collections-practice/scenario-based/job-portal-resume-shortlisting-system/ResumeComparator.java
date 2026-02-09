import java.util.Comparator;
import java.util.Set;

public class ResumeComparator implements Comparator<Resume> {

    private Set<String> requiredSkills;

    public ResumeComparator(Set<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    private int countMatches(Resume resume) {

        int count = 0;

        for(String skill : resume.getSkills()) {
            if(requiredSkills.contains(skill.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int compare(Resume r1, Resume r2) {

        int match1 = countMatches(r1);
        int match2 = countMatches(r2);

        // Descending order (highest match first)
        return match2 - match1;
    }
}
