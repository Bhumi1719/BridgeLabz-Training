import java.util.Scanner;

public class RectangleArea {
    
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);
        
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);
        
        int overlap = 0;
        if(right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return areaOfSqrA + areaOfSqrB - overlap;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coordinates of first rectangle (A B C D): ");
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        System.out.print("Enter coordinates of second rectangle (E F G H): ");
        int E = sc.nextInt();
        int F = sc.nextInt();
        int G = sc.nextInt();
        int H = sc.nextInt();

        int area = computeArea(A, B, C, D, E, F, G, H);
        System.out.println("The total area covered by the two rectangles is: " + area);
    }
}