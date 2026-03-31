import java.util.Scanner;

public class MCQExam extends Exam {
    private String[] questions;
    private String[] correctAnswers;
    private String[] userAnswers;

    public MCQExam(String name, String[] questions, String[] correctAnswers) {
        super(name);
        this.questions = questions;
        this.correctAnswers = correctAnswers;
        this.userAnswers = new String[questions.length];
    }

    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<questions.length; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            System.out.print("Your Answer: ");
            userAnswers[i] = sc.nextLine();
        }
    }

    @Override
    protected int evaluate() {
        int score = 0;
        for(int i=0; i<correctAnswers.length; i++) {
            if(userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                score += 5; 
            }
        }
        return score;
    }
}
