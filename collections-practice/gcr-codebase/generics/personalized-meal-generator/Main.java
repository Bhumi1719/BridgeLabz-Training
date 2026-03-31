import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Choose Meal Type:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Vegan");
        System.out.println("3. Keto");
        System.out.println("4. High-Protein");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        MealPlan plan = null;

        switch(choice) {
            case 1 : 
                plan = new VegetarianMeal(); 
                break;
            case 2 : 
                plan = new VeganMeal(); 
                break;
            case 3 : 
                plan = new KetoMeal(); 
                break;
            case 4 : 
                plan = new HighProteinMeal(); 
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        Meal<?> meal = MealGenerator.generate(name, plan);

        System.out.println("\nPersonalized Meal Plan:");
        meal.display();
    }
}
