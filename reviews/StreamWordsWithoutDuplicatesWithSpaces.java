import java.util.ArrayList;
import java.util.List;

public class StreamWordsWithoutDuplicatesWithSpaces {
    public static void main(String[] args) {
        String str = "india is country we lives in india india is great india";
        List<String> ls = new ArrayList<>();

        for(String s : str.split(" ")) {
            ls.add(s);
        }
        ls.stream().distinct().forEach(s -> System.out.print(s + " "));
    }    
}