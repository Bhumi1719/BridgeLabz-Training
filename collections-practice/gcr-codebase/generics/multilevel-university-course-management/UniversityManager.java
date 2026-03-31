import java.util.*;

class UniversityManager {

    public static void displayAllCourses(List<? extends CourseType> list) {
        for(CourseType c : list) {
            c.evaluate();
        }
    }
}
