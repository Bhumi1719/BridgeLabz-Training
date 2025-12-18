public class dividePens {
    public static void main(String[] args) {
        int pens = 14;
        int students = 3;

        // Calculate number of pens each student gets
        int pensPerStudent = pens / students;

        // Calcutlate remaining pens not distributed
        int remainingPens = pens % students;

        System.out.println("The Pen per Student is " + pensPerStudent + " and " + "the remaining pen not distributed is " + remainingPens);
    }
}