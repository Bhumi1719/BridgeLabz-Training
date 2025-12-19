import java.util.*;

public class EvenAndOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number ");
        int number = sc.nextInt();

        if(number >= 1){
            for(int i=1; i<=number; i++){
                if(i % 2 == 0){
                    System.out.println(i + " is Even");
                } else {
                    System.out.println(i + " is Odd");
                }
            }
        }else{
            System.out.println("The number " + number + " is not a natural number");
        }
    }
}   