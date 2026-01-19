import java.util.Scanner;

public class LemonadeChange {

        public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0 ; 
        for(int i= 0 ; i < bills.length ; i++){
            if(bills[i] == 5){
                five += 1 ; 
            }else if(bills[i] == 10 ){
                if(five >= 1){
                    five -= 1 ; 
                    ten += 1 ;
                }else{
                    return false ;
                }
            }else{
                if(five >= 1 && ten >= 1){
                    five-= 1;
                    ten-=1 ;
                }else if(five >= 3){
                    five-=3;
                }else{
                    return false ;
                }
            }
        }
        return true ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of bills: ");
        int bill = sc.nextInt();

        int[] bills = new int[bill];
        System.out.print("Enter the bills (5, 10, or 20): ");
        for(int i=0; i<bill; i++) {
            bills[i] = sc.nextInt();
        }

        boolean result = lemonadeChange(bills);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}