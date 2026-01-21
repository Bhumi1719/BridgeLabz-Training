import java.util.Scanner;

public class CodingExam extends Exam {
    private String code;

    // Creating a constructor of the subclass
    public CodingExam(String name) {
        super(name);
    }

    // Creating a method to take the user input for answers
    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your code output: ");
        code = sc.nextLine();
    }

    // Creating a method to evaluate the result
    @Override
    protected int evaluate() {
        if(code.contains("return")) {
            return 20;
        }
        return 5;
    }
}
