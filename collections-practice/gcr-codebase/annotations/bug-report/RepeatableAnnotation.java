import java.lang.reflect.Method;

public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {

        Method method = IssueTracker.class.getMethod("processData");

        BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);

        System.out.println("Bug Reports:");
        for(BugReport bug : bugReports) {
            System.out.println("- " + bug.description());
        }
    }
}
