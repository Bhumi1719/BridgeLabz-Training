public class GreetingImplement implements Greeting {


    @Override
    public void sayHello(String name) {
        System.out.println("\nHello, " + name + "!");
    }

    @Override
    public void sayGoodbye(String name) {
        System.out.println("\nGoodbye, " + name + "!");
    }
}


