import java.util.*;

public class StockSpan {

    public static int[] calculateSpan(int[] price) {
        int[] span = new int[price.length];

        Stack<Integer> st = new Stack<>();

        st.push(0);
        span[0] = 1;

        for(int i=1; i<price.length; i++) {
            while(!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
            span[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int number = sc.nextInt();

        int[] price = new int[number];

        System.out.print("Enter stock prices: ");
        for(int i=0; i<number; i++) {
            price[i] = sc.nextInt();
        }

        int[] span = calculateSpan(price);

        System.out.print("Stock Spans: ");
        for(int i=0; i<number; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
