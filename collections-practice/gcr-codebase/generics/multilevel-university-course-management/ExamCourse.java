class ExamCourse extends CourseType {
    public ExamCourse() {
        evaluationMethod = "Written Exam";
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating through " + evaluationMethod);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        evaluationMethod = "Assignments";
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating through " + evaluationMethod);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        evaluationMethod = "Research Work";
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating through " + evaluationMethod);
    }
}
