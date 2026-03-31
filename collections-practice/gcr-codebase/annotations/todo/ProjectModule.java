public class ProjectModule {
    
    @Todo(task = "Implement login feature", assignedTo = "Aryan", priority = "HIGH")
    public void login() {
        System.out.println("Login module");
    }

    @Todo(task = "Add forgot password feature", assignedTo = "Neha")
    public void forgotPassword() {
        System.out.println("Forgot password module");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Rahul", priority = "LOW")
    public void optimizeDB() {
        System.out.println("Database optimization");
    }
}
