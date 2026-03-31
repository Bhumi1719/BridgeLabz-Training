import java.util.*;

public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        // String validation: Only one word
        if (str1.contains(" ")) {
            System.out.println(str1 + " is an invalid word");
            return;
        }
        if (str2.contains(" ")) {
            System.out.println(str2 + " is an invalid word");
            return;
        }

        if(isReverse(str1, str2)) {
            String reverse = new StringBuilder(str1).reverse().toString();
            reverse = reverse.toLowerCase();

            for(int i=0; i<reverse.length(); i++) {
                if(reverse.charAt(i) == 'a' || reverse.charAt(i) == 'e' || reverse.charAt(i) == 'i' || reverse.charAt(i) == 'o' || reverse.charAt(i) == 'u') {
                    reverse = reverse.substring(0, i) + '@' + reverse.substring(i + 1);
                }
            }

            System.out.print("The transformed word is: " + reverse);
        } else {
            String newWord = new StringBuilder(str1).append(str2).toString();
            newWord = newWord.toUpperCase();

            int vowelCount = 0;
            int consonantCount = 0;

            for(int i=0; i<newWord.length(); i++) {
                char ch = newWord.charAt(i);

                if(ch >= 'A' && ch <= 'Z') {
                    if(isVowel(ch)) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            if (vowelCount > consonantCount) {
                printFirstTwoUnique(newWord, true);
            } else if (consonantCount > vowelCount) {
                printFirstTwoUnique(newWord, false);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }   

    static boolean isReverse(String str1, String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        String reversed = new StringBuilder(str1).reverse().toString();
        return reversed.equals(str2);
    }

    static boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }

    static void printFirstTwoUnique(String word, boolean printVowels) {
        String result = "";

        for(int i=0; i<word.length() && result.length() < 2; i++) {
            char ch = word.charAt(i);

            if(printVowels && isVowel(ch) && result.indexOf(ch) == -1) {
                result += ch;
            }

            if(!printVowels && !isVowel(ch) && ch >= 'A' && ch <= 'Z' && result.indexOf(ch) == -1) {
                result += ch;
            }
        }

        System.out.println(result);
    }

}
