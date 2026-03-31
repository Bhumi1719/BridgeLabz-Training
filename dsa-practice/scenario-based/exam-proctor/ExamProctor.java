import java.util.Scanner;

public class ExamProctor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExamEngine exam = new ExamEngine();

        while(true) {
            System.out.println("\n1.Visit Question");
            System.out.println("2.Answer Question");
            System.out.println("3.Last Visited");
            System.out.println("4.Submit");
            System.out.println("5.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Question ID: ");
                    int qid = sc.nextInt();
                    sc.nextLine();
                    exam.visitQuestion(qid);
                    break;

                case 2:
                    System.out.print("Enter Question ID: ");
                    int aq = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Answer: ");
                    String ans = sc.nextLine();
                    exam.answerQuestion(aq, ans);
                    break;

                case 3:
                    exam.showLastVisited();
                    break;

                case 4:
                    int score = exam.evaluate();
                    System.out.println("Exam Submitted!");
                    System.out.println("Your Score: " + score + "/5");
                    return;

                case 5:
                    System.out.println("Exited");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
