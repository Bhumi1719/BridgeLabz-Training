import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    
        public static void mergeSort(int[] books, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(books, left, mid);
            mergeSort(books, mid + 1, right);
            merge(books, left, mid, right);
        }
    }

        private static void merge(int[] bookPrices, int left, int mid, int right) {
            final int LEFT = mid - left + 1;
            final int RIGHT = right - mid;

            int[] leftArr = new int[LEFT];
            int[] rightArr = new int[RIGHT];

            System.arraycopy(bookPrices, left, leftArr, 0, LEFT);
            System.arraycopy(bookPrices, mid + 1, rightArr, 0, RIGHT);

            int i = 0;
            int j = 0;
            int k = left;
            while(i < LEFT && j < RIGHT) {
                if(leftArr[i] <= rightArr[j]) {
                    bookPrices[k++] = leftArr[i++];
                } else {
                    bookPrices[k++] = rightArr[j++];
                }
            }
            while(i < LEFT) {
                bookPrices[k++] = leftArr[i++];
            }
            while(j < RIGHT) {
                bookPrices[k++] = rightArr[j++];
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int books = sc.nextInt();

        int[] bookPrices = new int[books];

        System.out.print("Enter the price of each book: ");
        for(int i=0; i<books; i++) {
            bookPrices[i] = sc.nextInt();
        }

        mergeSort(bookPrices, 0, bookPrices.length - 1);
        System.out.print("The price of each book in ascending order is: " + Arrays.toString(bookPrices));
    }
}
