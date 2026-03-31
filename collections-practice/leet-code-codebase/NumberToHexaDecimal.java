import java.util.*;

public class NumberToHexaDecimal {

    static final char[] MAP = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public static String toHex(int num) {
        if(num == 0) {
            return "0";
        }

        String result = "";

        while(num != 0){
            result = MAP[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        String hexa = toHex(num);
        System.out.print("The number in hexa decimal is: " + hexa);
    }
}
