import java.util.*;

public class IPAddress {
    
    public static boolean isValidIPv4(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}" + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

        return ip.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the IP Address: ");
        String address = sc.nextLine();

        System.out.print("Is the given IP Address valid? " + isValidIPv4(address));
    }
}
