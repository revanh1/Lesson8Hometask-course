package Lesson8.Hometask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List <Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }


    public void addBook(Book book){
        books.add(book);
    }
    public boolean removeBook(String bookTitle){
        if(books.removeIf(book -> book.getTitle().equals(bookTitle))){
            return true;
        }
            return false;
        //instead of i used removeIf and lambda expression:

        //        for (Book book : books) {
        //            if (book.getTitle().equals(title)) {
        //                books.remove(book);
        //                return true;
        //            }
        //        }
        //        return false;
    }
    public List<Book> searchBookByTitle(String title){
        List<Book> foundBook = new ArrayList<>();
        for (Book book: books){   //here i used enhanced for loop
            if(book.getTitle().equals(title)){
                foundBook.add(book);
            }
        }
        return foundBook;
    }

    public List<Book> searchBookByAuthor(String author){
        return books.stream()   //but here i used strema to get result
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }


    public List<Book> searchBookByGenre(String genre){
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public List<Book> searchBookBy(String title){
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
    public List<Book> displaySortedBooksInformationByTitle(){
        List<Book> sortedBooks = new ArrayList<>();
        Collections.sort(sortedBooks, Comparator.comparing(Book::getTitle));
        return  sortedBooks;
        //we can write this part like this:

        //Collections.sort(sortedBooks, (book1, book2) -> book1.getAuthor().compareTo(book2.getAuthor()));
        //But for shorthand I used method reference instead of lambpda expression

    }

    public List<Book> displaySortedBooksInformationByYear(){
        List<Book> sortedBooks = new ArrayList<>();
        Collections.sort(sortedBooks, Comparator.comparing(Book::getPublicationYear));
        return  sortedBooks;
    }

    public List<Book> displaySortedBooksInformationByGenre(){
        List<Book> sortedBooks = new ArrayList<>();
        Collections.sort(sortedBooks, Comparator.comparing(Book::getGenre));
        return  sortedBooks;
    }

    public double calculateAveragePublicationYear(){
        if(books.isEmpty()) return 0;
        int totalYears = 0;
        for (Book book : books){
            totalYears += book.getPublicationYear();
        }
        return totalYears / books.size();

        //also, we can write for stream version:
        //return books.stream()
        //                .mapToInt(Book::getPublicationYear)
        //                .average()
        //                .orElse(0);
    }

    public int countBooks(){
        return books.size();
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
