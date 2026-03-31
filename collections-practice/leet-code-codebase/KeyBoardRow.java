import java.util.*;

public class KeyBoardRow {
    public static String[] findWords(String[] words) {

       ArrayList<String> ans=new ArrayList<>();
       final String FIRST = "qwertyuiop";
       final String SECOND ="asdfghjkl";
       final String THIRD ="zxcvbnm";

       for(String i : words){
            if(isinrow(i,FIRST) || isinrow(i,SECOND) || isinrow(i,THIRD)) {
                ans.add(i);
            }
       } 
       return ans.toArray(new String[0]);
    }

    private static boolean isinrow(String s,String row){
        for(char c:s.toCharArray()){
            if(row.indexOf(Character.toLowerCase(c))==-1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int number = sc.nextInt();
        sc.nextLine(); 

        String[] words = new String[number];

        System.out.println("Enter words:");
        for(int i=0; i<number; i++) {
            words[i] = sc.nextLine();
        }

        String[] result = findWords(words);

        System.out.println("\nWords that can be typed using one keyboard row:");
        for(String s : result) {
            System.out.println(s);
        }
    }
}