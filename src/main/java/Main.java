import CrudOperations.AuthorCrudOperations;
import CrudOperations.BookCrudOperations;
import CrudOperations.VisitorsCrudOperations;
import Model.Author;
import Model.Book;
import Model.Visitors;

import java.util.Arrays;
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
        List<Author> allAuthors = authorCrudOperations.findAll();
        System.out.println("List of authors");
        for(Author author : allAuthors){
            System.out.println(author);
        }
        List<Visitors> allVisitors = visitorsCrudOperations.findAll();
        System.out.println("List of subscribers");
        for(Visitors visitors : allVisitors){
            System.out.println(visitors);
        }

        List<Author> authorToSave = Arrays.asList(
            new Author(4,"Aristote",'M'),
            new Author(5,"Bella Poetry",'F'),
            new Author(6,"Benjamin Franklin",'M')
        );
        authorCrudOperations.saveAll(authorToSave);
    }
}
