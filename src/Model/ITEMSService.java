package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ITEMSService {
    public static void selectAll(List<ITEMS> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT x, y, z FROM Table ORDER BY x");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new ITEMS(results.getInt("ID"), results.getString("ItemName"), results.getString("ItemDesc"), results.getInt("Quantity"), results.getInt("UnitPrice"), results.getInt("TotalPrice")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
    public static ITEMS selectByID(int id, DatabaseConnection database) {
        ITEMS result = null;
        PreparedStatement statement = database.newStatement("SELECT x, y, z, FROM Table WHERE id = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new ITEMS(results.getInt("ID"), results.getString("ItemName"), results.getString("ItemDesc"), results.getInt("Quantity"), results.getInt("UnitPrice"), results.getInt("TotalPrice"));
                }
            }
        } catch(SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Table WHERE id = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }

    public static void save(ITEMS itemToSave, DatabaseConnection database) {

        ITEMS existingItem = null;
        if (itemToSave.getId() != 0) existingItem = selectById(itemToSave.getId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Table (id, itemName, itemDesc, quantity, price, totalPrice) VALUES (?, ?, ?, ?, ?, ?))");
                statement.setInt(1, itemToSave.getId());
                statement.setString(2, itemToSave.getItemName());
                statement.setString(3, itemToSave.getItemDesc());
                statement.setInt(4, itemToSave.getQuantity());
                statement.setInt(5, itemToSave.getPrice());
                statement.setInt(6, itemToSave.getTotalPrice());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Table SET id = ?, itemName = ?, itemDesc = ?, quantity = ?, price = ?, totalPrice = ?,  WHERE id = ?");
                statement.setInt(1, itemToSave.getId());
                statement.setString(2, itemToSave.getItemName());
                statement.setString(3, itemToSave.getItemDesc());
                statement.setInt(4, itemToSave.getQuantity());
                statement.setInt(5, itemToSave.getPrice());
                statement.setInt(6, itemToSave.getTotalPrice());
                statement.setInt(7, itemToSave.getId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
