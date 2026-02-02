import java.lang.annotation.*;
import java.lang.reflect.AnnotatedElement;

// Creating custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

// Applying custom annotation to a class
@Author(name = "Chetan Bhagat")
class Book {
}

// Retrieve annotation at runtime using Reflection
public class RetrieveAnnotation {
    public static void main(String[] args) {

        Class<Book> cls = Book.class;

        if(cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        } else {
            System.out.println("Author annotation not present");
        }
    }
}
