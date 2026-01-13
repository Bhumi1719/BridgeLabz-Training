import java.util.Scanner;

public class AddBinary {
    
    public static String addBinary(String str1, String str2) {
        // Convert strings to character arrays
        char[] charArrA = str1.toCharArray();
        char[] charArrB = str2.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = charArrA.length - 1;
        int j = charArrB.length - 1;

        int CARRY = 0;

        while(i >= 0 || j >= 0 || CARRY > 0) {
            int aNum = i >= 0 ? charArrA[i] - '0' : 0;
            int bNum = j >= 0 ? charArrB[j] - '0' : 0;

            int sum = aNum + bNum + CARRY;
            int digit = sum % 2;
            CARRY = sum / 2;
            i--;
            j--;

            sb.append((char)(digit + '0'));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first binary string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second binary string: ");
        String str2 = sc.nextLine();

        String result = addBinary(str1, str2);
        System.out.println("Sum of binary strings is " + result);
    }
}
