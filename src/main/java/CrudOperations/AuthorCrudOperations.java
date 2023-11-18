package CrudOperations;

import DatabaseConfig.DatabaseManager;
import Interface.CrudOperations;
import Model.Author;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class AuthorCrudOperations implements CrudOperations<Author> {
    private static final DatabaseManager databaseManager = DatabaseManager.getInstance();
    @Override
    public List<Author> findAll() {
        List<Author> listOfAuthor = new ArrayList<>();
        String sql = "SELECT * FROM author";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                char sex = resultSet.getString("sex").charAt(0);
                Author authors = new Author(id,name,sex);
                listOfAuthor.add(authors);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfAuthor;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String sql = "insert into author (id,name,sex) values (?,?,?)";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            for(Author author : toSave){
                statement.setInt(1,author.getId());
                statement.setString(2,author.getName());
                statement.setString(3,String.valueOf(author.getSex()));
                statement.addBatch();
                int[] affectedRows = statement.executeBatch();
                if(affectedRows.length == toSave.size()){
                    System.out.println("All authors successfully backed up");
                }
                else{
                    System.out.println("Some authors could not be saved.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String sql = "insert into author (id,name,sex) values (?,?,?)";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            statement.setInt(1,toSave.getId());
            statement.setString(2,toSave.getName());
            statement.setString(3,String.valueOf(toSave.getSex()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql = "DELETE FROM author WHERE id = ?";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            statement.setInt(1,toDelete.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toDelete;
    }
}
