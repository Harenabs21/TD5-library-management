package CrudOperations;

import DatabaseConfig.DatabaseManager;
import Interface.CrudOperations;

import Model.Book;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    private static final DatabaseManager databaseManager = DatabaseManager.getInstance();
    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM book";
        List<Book> listOfBooks = new ArrayList<>();
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int pageNumber = resultSet.getInt("page_number");
                String topic = resultSet.getString("topic");
                Date releaseDate = resultSet.getDate("release_date");
                Book books = new Book(id,name,pageNumber,topic,releaseDate);
                listOfBooks.add(books);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfBooks;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        String sql = "INSERT INTO book (id,name,page_number,topic,release_date) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            for (Book book : toSave){
                statement.setInt(1,book.getId());
                statement.setString(2,book.getBookName());
                statement.setInt(3,book.getPageNumbers());
                statement.setString(4,book.getTopic());
                statement.setDate(5,book.getReleaseDate());
                statement.addBatch();
                int[] affectedRows = statement.executeBatch();
                if(affectedRows.length == toSave.size()){
                    System.out.println("All books successfully backed up");
                }
                else{
                    System.out.println("Some books could not be saved.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        String sql = "INSERT INTO book (id,name,page_number,topic,release_date) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            statement.setInt(1,toSave.getId());
            statement.setString(2,toSave.getBookName());
            statement.setInt(3,toSave.getPageNumbers());
            statement.setString(4,toSave.getTopic());
            statement.setDate(5,toSave.getReleaseDate());
            statement.executeUpdate();
            return toSave;
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE FROM book WHERE id = ?";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            statement.setInt(1,toDelete.getId());
            statement.executeUpdate();
            return toDelete;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
