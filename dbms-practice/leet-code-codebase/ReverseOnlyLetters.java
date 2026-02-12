import java.util.Scanner;

public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int start = 0; 
        int end = arr.length - 1;

        while(start < end) {
            if(Character.isLetter(arr[start]) && Character.isLetter(arr[end])) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else if(!Character.isLetter(arr[start])) {
                start++;
            } else {
                end--;
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        System.out.print("Reversed string is: " + reverseOnlyLetters(str));
    }
} 