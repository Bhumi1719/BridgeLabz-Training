class Book {
    String title, author, genre;

    Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(!(o instanceof Book)) {
            return false;
        }
        
        Book b = (Book) o;
        return title.equals(b.title) && author.equals(b.author);
    }

    public int hashCode() {
        return title.hashCode() + author.hashCode();
    }

    public String toString() {
        return title + " by " + author;
    }
}