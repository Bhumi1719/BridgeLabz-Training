class Meal<T extends MealPlan> {
    private String userName;
    private T mealPlan;

    public Meal(String userName, T mealPlan) {
        this.userName = userName;
        this.mealPlan = mealPlan;
    }

    public void display() {
        System.out.println("User: " + userName);
        mealPlan.showMeals();
    }

    public T getMealPlan() {
        return mealPlan;
    }
}
