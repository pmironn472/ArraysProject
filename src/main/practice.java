package main;

//CRUD - create ,replace,delete.

//add,delete,search,

public class practice {
    private static Book[] livraryBooks;

    public static void main(String[] args) {

        livraryBooks = new Book[10];
        addBook(new Book("Java 0"));
        addBook(new Book("Java 1"), 1);
        addBook(new Book("Java 2"), 2);
        addBook(new Book("Java 4"), 6);

        updateTitle("ava development", 5);

        deleteBook(2);

        addBook(new Book("Java 3"), true);

        readAll();

        System.out.println();
        System.out.println();

        readAll(true);

        System.out.println();
        System.out.println();


        findByTitle("Java 3");

        System.out.println();
        System.out.println();

        swapBooks("Java 3",new Book("Java 9"));


    }

    public static void addBook(Book book) {
        livraryBooks[0] = book;
    }

    public static void addBook(Book book, int index) {
        livraryBooks[index] = book;
    }

    public static void addBook(Book book, boolean atTheEnd) {
        int i = 9;
        while (i <= livraryBooks.length - 1) {
            atTheEnd = livraryBooks[i] != null;
            if (atTheEnd) {
                livraryBooks[i + 1] = book;
                return;

            }

            i--;
        }
    }

    public static void updateTitle(String newTitle, int index) {
        try {

            livraryBooks[index].setTitle(newTitle);
        } catch (NullPointerException e) {
            System.err.println("You can't update when the place is empty");
        }
    }

    public static void deleteBook(int index) {
        livraryBooks[index] = null;
    }

    public static void readAll() {
        for (int i = 0; i < livraryBooks.length; i++) {
            System.out.println(livraryBooks[i]);
        }
    }

    public static void readAll(boolean excludeEmpty) {
        for (int i = 0; i < livraryBooks.length; i++) {
            excludeEmpty = livraryBooks[i]!=null;
            if (excludeEmpty) {
                System.out.println(livraryBooks[i] + " " + i);
            }
        }
    }

    public static void findByTitle(String title) {

        for (int i = 0; i < livraryBooks.length; i++) {
            if (livraryBooks[i] != null) {
                if (title.equals(livraryBooks[i].getTitle())) {
                    System.out.println("We find the book ----> " + livraryBooks[i].getTitle() + " On the place " + i);

                }
            }
        }

    }

    public static void swapBooks(String title, Book book) {
        try {
            for (int i = 0; i < livraryBooks.length; i++) {
                if (livraryBooks[i] != null) {
                    if (title.equals(livraryBooks[i].getTitle())) {
                        System.out.println("We swaped the book " + livraryBooks[i] + " with " + (livraryBooks[i] = book));
                        return;
                    }
                }
            }
        } catch (NullPointerException e) {
            System.err.println("There is no such Book wich we can to swap");
        }
    }


}


class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [" + title + "]";
    }
}
