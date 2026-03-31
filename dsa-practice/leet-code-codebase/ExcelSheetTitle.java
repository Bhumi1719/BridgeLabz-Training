import java.util.*;

public class ExcelSheetTitle {
    
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while(columnNumber > 0) {
            columnNumber--; 
            char ch = (char) ('A' + (columnNumber % 26));
            result.insert(0, ch); 
            columnNumber /= 26;
        }
        
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the column number: ");
        int columnNumber = sc.nextInt();

        String title = convertToTitle(columnNumber);
        System.out.println("Excel Sheet Title is: " + title);
    }
}
