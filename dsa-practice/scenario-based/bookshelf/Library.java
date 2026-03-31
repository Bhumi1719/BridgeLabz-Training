import java.util.*;

class Library {

    HashMap<String, LinkedList<Book>> catalog = new HashMap<>();
    HashSet<Book> uniqueBooks = new HashSet<>();

    void addBook(Book b) {
        if(!uniqueBooks.add(b)) {
            System.out.println("Duplicate book not allowed.");
            return;
        }
        catalog.putIfAbsent(b.genre, new LinkedList<>());
        catalog.get(b.genre).add(b);

        System.out.println("Book added.");
    }

    void borrowBook(String title, String author, String genre) {
        LinkedList<Book> list = catalog.get(genre);
        if (list == null) {
            System.out.println("Genre not found.");
            return;
        }
        Iterator<Book> it = list.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.title.equals(title) && b.author.equals(author)) {
                it.remove();
                uniqueBooks.remove(b);
                System.out.println("Book borrowed.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    void display() {
        if(catalog.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for(String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for(Book b : catalog.get(genre)) {
                System.out.println(b);
            }
        }
    }
}