import java.util.*;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] str) {
        if(str == null || str.length == 0) {
            return "";
        }

        String prefix = str[0];
        int prefixLength = prefix.length();

        for(int i=1; i<str.length; i++) {
            String s = str[i];
            while(prefixLength > s.length() || !prefix.equals(s.substring(0, prefixLength))) {
                prefixLength --;

                if(prefixLength == 0) {
                    return "";
                }

                prefix = prefix.substring(0, prefixLength);
            }
        }

        return prefix;        
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
