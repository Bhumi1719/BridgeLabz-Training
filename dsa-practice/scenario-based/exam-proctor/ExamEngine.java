import java.util.*;

public class ExamEngine {
    Stack<Integer> navigation = new Stack<>();
    
    HashMap<Integer, String> answers = new HashMap<>();
    HashMap<Integer, String> correctAnswers = new HashMap<>();

    public ExamEngine() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
        correctAnswers.put(5, "A");
    }

    public void visitQuestion(int qid) {
        navigation.push(qid);
        System.out.println("Visited Question: " + qid);
    }

    public void answerQuestion(int qid, String ans) {
        answers.put(qid, ans);
        System.out.println("Saved Answer for Q" + qid);
    }

    public void showLastVisited() {
        if (navigation.isEmpty())
            System.out.println("No navigation yet.");
        else
            System.out.println("Last Visited Question: " + navigation.peek());
    }

    public int evaluate() {
        int score = 0;
        for (int qid : correctAnswers.keySet()) {
            String correct = correctAnswers.get(qid);
            String given = answers.get(qid);
            if (correct.equalsIgnoreCase(given)) {
                score++;
            }
        }
        return score;
    }
}
