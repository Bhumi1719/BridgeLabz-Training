import java.util.Scanner;

public class Base7 {
    public static String convertToBase7(int num) {
        String s = "";
        String reverse = "";

        int original = num;
        num = Math.abs(num);

        if(num == 0){
            return "0";
        }

        while(num > 0){
            s += num%7;
            num /= 7;
        }

        if(original < num){
            s += "-";
        }
        
        for(int i=s.length()-1; i>=0; i--){
            reverse += s.charAt(i);
        }


        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Required string with base 7 representation is: " + convertToBase7(number));
    }
}
