import java.util.Scanner;

public class Browser {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BrowserBuddy browser = new BrowserBuddy();

        while(true) {
            System.out.println("\n1.Open URL");
            System.out.println("2.Back");
            System.out.println("3.Forward");
            System.out.println("4.Close Tab");
            System.out.println("5.Restore Tab");
            System.out.println("6.Show Current Tab");
            System.out.println("7.Exit");

            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    browser.open(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    browser.closeTab();
                    break;
                case 5:
                    browser.restoreTab();
                    break;
                case 6:
                    browser.show();
                    break;
                case 7:
                    System.out.println("Exited");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
