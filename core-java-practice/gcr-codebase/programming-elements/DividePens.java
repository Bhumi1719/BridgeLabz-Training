public class DividePens {
    public static void main(String[] args) {
        int PENS = 14;
        int STUDENTS = 3;

        // Calculate number of pens each student gets
        int pensPerStudent = PENS / STUDENTS;

        // Calcutlate remaining pens not distributed
        int remainingPens = PENS % STUDENTS;

        System.out.println("The Pen per Student is " + pensPerStudent + " and " + "the remaining pen not distributed is " + remainingPens);
    }
}