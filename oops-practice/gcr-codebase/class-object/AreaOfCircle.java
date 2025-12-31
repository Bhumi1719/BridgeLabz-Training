import java.util.Scanner;
 
// Creating a class named Circle with attribute in it
class Circle {
	double radius;
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	// Creating method to calculate the circumference of the circle
	double calculateCircumference() {
		return 2 * Math.PI * radius;
	}
	
	// Creating a method to calculate the area of the circle
	double calculateArea() {
		return Math.PI * radius * radius;
	}
	
	// Creating a method to display the circumference and area of circle
	void display() {
		System.out.println(String.format("\nCircumference of circle with radius " + radius + " is %.4f", calculateCircumference()));
		System.out.println(String.format("Area of circle with radius " + radius + " is %.4f", calculateArea()));
	}
}
public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the radius: ");
		double radius = sc.nextDouble();
		
		// Creating an object of the class to call it
		Circle circle = new Circle(radius);
		circle.display();
	}

}
