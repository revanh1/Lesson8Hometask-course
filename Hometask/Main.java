package Lesson8.Hometask;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("Yalnizliqdan sizofreniyaya", "oar", "psycology", 2012));
        library.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        library.addBook(new Book("How to Win Friends & Influence People", "Dale Carnegie", "personal development", 1936));
        library.addBook(new Book("Oyunbaz", "Vulf Dorn", "fiction, psycology, ", 2011));


        //searhing
        System.out.println("Books by George Orwell:");
        library.searchBookByAuthor("George Orwell").forEach(System.out::println);
        System.out.println("=======================================");

        //removing
        if (library.removeBook("Oyunbaz")) {
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Book not found");
        }
        System.out.println("=======================================");

        //sorting
        //----->>> problem asagidadir, displaySortedBooksInformationByYear metodu geriye hecne dondermir
        System.out.println("Books sorted by publication year:");
        for (Book book : library.displaySortedBooksInformationByYear()) {
            System.out.println(book);
        }
        System.out.println("=======================================");

        //average publication year
        System.out.println("Average publication year: " + library.calculateAveragePublicationYear());
        System.out.println("=======================================");

        //number of books
        System.out.println("Number of books: " + library.countBooks());
        System.out.println("=======================================");

    }
}
