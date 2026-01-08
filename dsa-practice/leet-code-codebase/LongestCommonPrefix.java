import java.util.*;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] str) {
        if(str == null || str.length == 0) {
            return "";
        }

        String PREFIX = str[0];
        int PREFIX_LENGTH = PREFIX.length();

        for(int i=1; i<str.length; i++) {
            String s = str[i];
            while(PREFIX_LENGTH > s.length() || !PREFIX.equals(s.substring(0, PREFIX_LENGTH))) {
                PREFIX_LENGTH --;

                if(PREFIX_LENGTH == 0) {
                    return "";
                }

                PREFIX = PREFIX.substring(0, PREFIX_LENGTH);
            }
        }

        return PREFIX;        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        System.out.print("Enter the string: ");
        String[] str = new String[size];

        System.out.println("Enter the elements in string array: ");
        for(int i=0; i<size; i++) {
            str[i] = sc.next();
        }
        System.out.println(longestCommonPrefix(str));
    }
}
