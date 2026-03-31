public class UserController {
    @Inject
    private GreetingService greetingService;

    public void sayHello(String name) {
        greetingService.greet(name);
    }
}
