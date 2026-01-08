import java.util.*;

public class RomanToInteger {

    public static int romanToInt(String str) {
        Map<Character, Integer> m = new HashMap<>();
        
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int RESULT = 0;
        
        for(int i=0; i<str.length(); i++) {
            if(i<str.length() - 1 && m.get(str.charAt(i)) < m.get(str.charAt(i + 1))) {
                RESULT -= m.get(str.charAt(i));
            } else {
                RESULT += m.get(str.charAt(i));
            }
        }        
        return RESULT;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the Roman number: ");
        String roman = sc.next();

        System.out.println("Integer obtained from the given Roman number is: " + romanToInt(roman));
    }
}
