import java.util.*;

public class ExcelsheetNumber {
    
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (char c : columnTitle.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Excel sheet title: ");
        String columnTitle = sc.nextLine();

        int number = titleToNumber(columnTitle);
        System.out.println("Column Number is: " + number);
    }
}
