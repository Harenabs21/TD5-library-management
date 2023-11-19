package CrudOperations;

import DatabaseConfig.DatabaseManager;
import Interface.CrudOperations;
import Model.Visitors;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
public class VisitorsCrudOperations implements CrudOperations<Visitors> {
    private static final DatabaseManager databaseManager = DatabaseManager.getInstance();
    @Override
    public List<Visitors> findAll() {
        String sql = "SELECT * FROM visitor";
        List<Visitors> listOfVisitor = new ArrayList<>();
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String reference = resultSet.getString("reference");
                Visitors visitors = new Visitors(id,name,reference);
                listOfVisitor.add(visitors);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfVisitor;
    }

    @Override
    public List<Visitors> saveAll(List<Visitors> toSave) {
        String sql = "insert into visitor (id,name,reference values(?,?,?)";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            for (Visitors visitors : toSave){
                statement.setInt(1,visitors.getId());
                statement.setString(2,visitors.getName());
                statement.setString(3,visitors.getReference());
                statement.addBatch();

            }
            int[] affectedRows = statement.executeBatch();
            if(affectedRows.length == toSave.size()){
                System.out.println("All visitors successfully backed up");
            }
            else{
                System.out.println("Some visitors could not be saved.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Visitors save(Visitors toSave) {
        String sql = "insert into visitor (id,name,reference values(?,?,?)";
        try{
            PreparedStatement statement = databaseManager.getPreparedStatement(sql);
            statement.setInt(1,toSave.getId());
            statement.setString(2,toSave.getName());
            statement.setString(3,toSave.getReference());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toSave;
    }

    @Override
    public Visitors delete(Visitors toDelete) {
        String sql = "delete from visitor where id = ?";
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
