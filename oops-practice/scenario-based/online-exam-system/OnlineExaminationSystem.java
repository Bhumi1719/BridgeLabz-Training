import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineExaminationSystem {
    
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Exam> exams = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\nOnline Examination System");
            System.out.println("1. Create Exam");
            System.out.println("2. Add Question to Exam");
            System.out.println("3. Enroll Student");
            System.out.println("4. Submit Answer");
            System.out.println("5. Generate Result");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            int choice;
            if(sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); 
            } else {
                System.out.println("Invalid input! Enter a number 1-6.");
                sc.nextLine();
                continue;
            }

            switch(choice) {
                case 1: 
                    System.out.print("Enter exam ID: ");
                    int examId = sc.nextInt();
                    sc.nextLine();

                    String examName;

                    while (true) {
                        System.out.print("Enter exam name: ");
                        examName = sc.nextLine();
                        if (!examName.isEmpty() && examName.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Name must contain letters and spaces only.");
                        }
                    }
                    System.out.print("Enter exam duration in minutes: ");
                    int duration = sc.nextInt();
                    sc.nextLine();

                    LocalDateTime endTime = LocalDateTime.now().plusMinutes(duration);
                    Exam exam = new Exam(examId, examName, endTime);
                    exams.add(exam);
                    System.out.println("Exam created: " + examName + " (Ends at " + endTime + ")");
                    break;

                case 2: 
                    if(exams.isEmpty()) {
                        System.out.println("No exams available! Create an exam first.");
                        break;
                    }
                    System.out.print("Enter exam ID to add question: ");
                    int addQExamId = sc.nextInt();
                    sc.nextLine();
                    Exam examToAdd = findExam(exams, addQExamId);
                    if (examToAdd == null) {
                        System.out.println("Exam not found!");
                        break;
                    }

                    System.out.print("Enter question ID: ");
                    int qId = sc.nextInt();
                    sc.nextLine();

                    String qText;

                    while (true) {
                        System.out.print("Enter question text: ");
                        qText = sc.nextLine();
                        if (!qText.isEmpty() && qText.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Question text must contain letters and spaces only.");
                        }
                    }

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Question type (1-Objective, 2-Descriptive): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    if (type == 1) {
                        System.out.print("Enter correct answer: ");
                        String correctAns = sc.nextLine();
                        examToAdd.addQuestion(new ObjectiveQuestion(qId, qText, marks, correctAns));
                    } else {
                        examToAdd.addQuestion(new DescriptiveQuestion(qId, qText, marks));
                    }
                    System.out.println("Question added successfully!");
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int sId = sc.nextInt();
                    sc.nextLine();

                    String sName;

                    while (true) {
                        System.out.print("Enter student name: ");
                        sName = sc.nextLine();
                        if (!sName.isEmpty() && sName.matches("[a-zA-Z ]+")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Name must contain letters and spaces only.");
                        }
                    }
                    Student student = new Student(sId, sName);
                    students.add(student);

                    System.out.print("Enter exam ID to enroll in: ");
                    int eIdEnroll = sc.nextInt();
                    sc.nextLine();
                    Exam examEnroll = findExam(exams, eIdEnroll);
                    if (examEnroll != null) {
                        examEnroll.enrollStudent(student);
                        System.out.println("Student enrolled in exam: " + examEnroll.getExamName());
                    } else {
                        System.out.println("Exam not found!");
                    }
                    break;

                case 4: // Submit Answer
                    System.out.print("Enter student ID: ");
                    int stuId = sc.nextInt();
                    sc.nextLine();
                    Student stu = findStudent(students, stuId);
                    if (stu == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter exam ID: ");
                    int exId = sc.nextInt();
                    sc.nextLine();
                    Exam ex = findExam(exams, exId);
                    if (ex == null) {
                        System.out.println("Exam not found!");
                        break;
                    }

                    for (Question q : ex.getQuestions()) {
                        System.out.println("Q" + q.getQuestionId() + ": " + q.getQuestionText());
                        System.out.print("Your answer: ");
                        String ans = sc.nextLine();
                        stu.submitAnswer(q.getQuestionId(), ans);
                    }
                    System.out.println("Answers submitted successfully!");
                    break;

                case 5: // Generate Result
                    System.out.print("Enter student ID: ");
                    int stIdRes = sc.nextInt();
                    sc.nextLine();
                    Student sRes = findStudent(students, stIdRes);
                    if (sRes == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter exam ID: ");
                    int exIdRes = sc.nextInt();
                    sc.nextLine();
                    Exam exRes = findExam(exams, exIdRes);
                    if (exRes == null) {
                        System.out.println("Exam not found!");
                        break;
                    }

                    EvaluationStrategy objEval = new ObjectiveEvaluation();
                    EvaluationStrategy descEval = new DescriptiveEvaluation();
                    try {
                        int scoreObj = objEval.evaluate(exRes, sRes);
                        int scoreDesc = descEval.evaluate(exRes, sRes);
                        System.out.println("Results for " + sRes.getName() + ":");
                        System.out.println("Objective Score: " + scoreObj);
                        System.out.println("Descriptive Score: " + scoreDesc);
                        System.out.println("Total Score: " + (scoreObj + scoreDesc));
                    } catch (ExamTimeExpiredException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Exited");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Enter 1-6.");
            }
        }
    }

    // Helper methods
    private static Exam findExam(List<Exam> exams, int examId) {
        for (Exam e : exams) {
            if (e.getExamId() == examId) return e;
        }
        return null;
    }

    private static Student findStudent(List<Student> students, int studentId) {
        for (Student s : students) {
            if (s.getStudentId() == studentId) return s;
        }
        return null;
    }
}
