import java.util.*;

public class VoteArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Declaring the array for 10 students
        int[] studentAge = new int[10];

        System.out.print("Enter the age of students: ");
        // Taking the user input age for each student
        for(int i=0; i<studentAge.length; i++){
            studentAge[i] = sc.nextInt();
        }

        for(int i=0; i<studentAge.length; i++){
            if(studentAge[i] < 0){
                System.out.println("Invalid age");
            } else{
                if(studentAge[i] >= 18){
                    System.out.println("The student with age " + studentAge[i] + " can vote");
                } else{
                    System.out.println("The student with age " + studentAge[i] + " cannot vote");
                }
            }
        }
    }
}