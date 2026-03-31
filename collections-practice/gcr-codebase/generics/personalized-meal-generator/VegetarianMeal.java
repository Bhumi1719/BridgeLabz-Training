class VegetarianMeal implements MealPlan {
    public void showMeals() {
        System.out.println("Vegetarian: Dal, Rice, Paneer, Vegetables");
    }
    public String getType() { 
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public void showMeals() {
        System.out.println("Vegan: Salad, Beans, Fruits, Nuts");
    }
    public String getType() { 
        return "Vegan"; 
    }
}

class KetoMeal implements MealPlan {
    public void showMeals() {
        System.out.println("Keto: Eggs, Chicken, Cheese, Nuts");
    }
    public String getType() { 
        return "Keto"; 
    }
}

class HighProteinMeal implements MealPlan {
    public void showMeals() {
        System.out.println("High Protein: Eggs, Fish, Chicken, Beans");
    }
    public String getType() { 
        return "High-Protein"; 
    }
}
