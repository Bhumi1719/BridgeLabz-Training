import java.util.*;

public class CountAndSay {

    public static String countAndSay(int n) {
       String str = "1"; 
        for(int j=1; j<n; j++) {  
            int i = 0;
            int count = 1; 

            StringBuilder temp = new StringBuilder();

            while(i < str.length() - 1) {
                if(str.charAt(i) == str.charAt(i + 1)) {
                    count++;  
                } else {
                    temp.append(count).append(str.charAt(i));  
                    count = 1; 
                }
                i++;
            }
            temp.append(count).append(str.charAt(i)); 
            str = temp.toString();
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the term number: ");
        int number = sc.nextInt();

        String result = countAndSay(number);
        System.out.println("The " + number + "th term of the Count and Say sequence is: " + result);
    }
}
