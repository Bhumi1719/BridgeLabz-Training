import java.util.*;

public class OnlineExamination {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Enter the student name: ");
            String name = sc.nextLine();

            Student student = new Student(1, name);

            System.out.println("\n1. MCQ Exam");
            System.out.println("2. Coding Exam");
            System.out.println("3. Exit");

            System.out.print("\nEnter the type of exam: ");
            int type = sc.nextInt();

            Exam exam = null;

            switch(type) {
                case 1 :
                    String[] questions = {
                        "Java is platform independent? (Yes/No)",
                        "Which keyword is used for inheritance? (extends/implements)",
                        "Java supports multiple inheritance using classes? (Yes/No)"
                    };

                    String[] answers = {"Yes", "extends", "No"};

                    MCQExam mcq = new MCQExam("MCQ Test", questions, answers);
                    mcq.takeInput();
                    exam = mcq;
                    break;

                case 2 :
                    CodingExam codeExam = new CodingExam("Coding Test");
                    codeExam.takeInput();
                    exam = codeExam;
                    break;

                case 3 :
                    System.out.println("Exited");
                    System.exit(0);

                default :
                    System.out.println("Invalid user input");
            }

            int score = exam.startEvaluation();

            System.out.println();
            System.out.println("Student: " + student.getName());
            System.out.println("Exam: " + exam.getExamName());
            System.out.println("Score: " + score);
        }        
    }
}