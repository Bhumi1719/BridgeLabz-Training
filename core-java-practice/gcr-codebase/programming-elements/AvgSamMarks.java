public class AvgSamMarks {
    public static void main(String[] args) {
        // Marks obtained by Sam in Maths
        int MARKS_MATHS = 94;

        //Marks obtained by Sam in Physics
        int MARKS_PHYSICS = 95;

        // Marks obtained by Sam in Chemistry
        int MARKS_CHEMISTRY = 96;

        // Calculate average marks
        double averageMarks = (MARKS_MATHS + MARKS_PHYSICS + MARKS_CHEMISTRY) / 3.0;

        // Print the average marks
        System.out.println("Sam's average marks in PCM is " + averageMarks);
    }
}