import java.util.Scanner;
import java.util.Stack;

public class SimplifyPath {
    
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");

        for(int i=0; i<str.length; i++){
            if(str[i].isEmpty()){
                continue;
            }

            if(str[i].equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!str[i].equals("..") && !str[i].equals(".")){
                stack.push(str[i]);
            }
        }

        if(stack.isEmpty()){ 
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()).insert(0, "/");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the path to simplify: ");
        String path = sc.nextLine();

        String simplifiedPath = simplifyPath(path);
        System.out.println("Simplified Path: " + simplifiedPath);
    }
}
