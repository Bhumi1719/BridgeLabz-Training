class MealGenerator {
    public static <T extends MealPlan> Meal<T> generate(String user, T plan) {
        if(plan == null) {
            throw new IllegalArgumentException("Invalid Meal Plan!");
        }

        System.out.println("Generating " + plan.getType() + " Meal Plan");
        return new Meal<>(user, plan);
    }
}
