import java.util.Scanner;

public class Maximum69Number {
    public static int maximum69Number(int num) {
        char[] digits = String.valueOf(num).toCharArray();  

        for(int i=0; i<digits.length; i++) {
            if(digits[i] == '6') {
                digits[i] = '9';
                break; 
            }
        }

        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("The maximum 69 number is: " + maximum69Number(number));
    }
}