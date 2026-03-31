// Creating a class named circle construct with attributes in it
class CircleConstruct {
    double radius;

    // Making a Default constructor
    CircleConstruct() {
        this.radius = 1.0; 
    }

    // Making a Parameterized constructor
    CircleConstruct(double radius) {
        this.radius = radius;
    }

    // Method for calculating the circumference of circle
    double circumference() {
        return 2 * Math.PI * radius;
    }
    
    // Method for calculating the area of circle
    double area() {
        return Math.PI * radius * radius;
    }

    // Method for displaying the circle details
    void display() {
        System.out.println("Radius of the circle: " + radius);
        System.out.println(String.format("Circumference of the circle: %.4f" , circumference())); // Calling the method to calculate circumference of circle
        System.out.println(String.format("Area of the circle: %.4f" , area())); // Calling method to calculate area of circle
    }
    
}
    
public class AreaConstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creating an object of the class for default constructor
		CircleConstruct circle1 = new CircleConstruct();
		System.out.println("These are details of the circle using default constructor");
		System.out.println(); // For extra line
        circle1.display(); // Calling the method to display the details of the circle1

        System.out.println("-----------------------------------------------------------------");
        
        // Creating an object of the class for parameterized constructor
        CircleConstruct circle2 = new CircleConstruct(5.0);
        System.out.println("These are details of the circle using parameterized constructor");
        System.out.println(); // For extra line
        circle2.display(); // Calling the method to display the details of the circle2

	}

}
