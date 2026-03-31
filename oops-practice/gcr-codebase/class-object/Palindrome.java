// Making a class named palindrome checker with attributes in it
class PalindromeChecker {
    String text;
 
    // Making a constructor of the class
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method for checking if the string is palindrome or not
    boolean isPalindrome() {
    	String name = text.toLowerCase().replace(" ", "");
        String reverse = "";

        for(int i=name.length() - 1; i>=0; i--) {
            reverse = reverse + name.charAt(i);
        }

        return name.equals(reverse);
    }

    // Method for displaying the result
    void displayResult() {
        if(isPalindrome()) {
            System.out.println(text + " is palindrome");        
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}
public class Palindrome {
	public static void main(String[] args) {
		
		// Making an object of the class to call it by name for string1
		PalindromeChecker palindrome1 = new PalindromeChecker("A man a plan a canal Panama");
		palindrome1.displayResult(); // Calling the method to display the result
		 
		// Making an object of the class to call it by name for sting2
	    PalindromeChecker palindrome2 = new PalindromeChecker("Hello");
	    palindrome2.displayResult(); // Calling the method to display the result	
	     
	}
}
