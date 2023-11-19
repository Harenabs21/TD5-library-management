import CrudOperations.AuthorCrudOperations;
import CrudOperations.BookCrudOperations;
import CrudOperations.VisitorsCrudOperations;
import Model.Author;
import Model.Book;
import Model.Visitors;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        BookCrudOperations bookCrudOperations = new BookCrudOperations();
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        VisitorsCrudOperations visitorsCrudOperations = new VisitorsCrudOperations();

        // Tester la méthode findAll pour la table book
        List<Book> allBooks = bookCrudOperations.findAll();
        System.out.println("List of books :");
        for (Book book : allBooks) {
            System.out.println(book);
        }
        // Tester la méthode findAll pour la table author
        List<Author> allAuthors = authorCrudOperations.findAll();
        System.out.println("List of authors");
        for(Author author : allAuthors){
            System.out.println(author);
        }
        // Tester la méthode findAll pour la table visitor
        List<Visitors> allVisitors = visitorsCrudOperations.findAll();
        System.out.println("List of subscribers");
        for(Visitors visitors : allVisitors){
            System.out.println(visitors);
        }
        // Tester la méthode saveAll pour la table author
        List<Author> authorToSave = Arrays.asList(
            new Author(4,"Aristote",'M'),
            new Author(5,"Bella Poetry",'F'),
            new Author(6,"Benjamin Franklin",'M')
        );
        authorCrudOperations.saveAll(authorToSave);
        // Tester la méthode save pour la table book
        Book toSave = new Book(4,"Pride and Prejudice", 300, Book.Topic.ROMANCE, new java.sql.Date(new Date().getTime()));
        bookCrudOperations.save(toSave);
        // Tester la méthode delete pour la table visitor
        Visitors visitors = new Visitors();
        visitors.setId(3);
        visitorsCrudOperations.delete(visitors);
    }
}
