package crud;

import java.sql.*;

public class DBReaderWriter {
    public static final String password = "root";
    public static final String login = "root";
    public static final String path = "jdbc:mysql://localhost:3306/";
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String DBName = "mydatabase";
    public static final String fullConnection = path.concat(DBName);

    private static Connection setConnectionToServer(String path) {
        Connection dbConnection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(path, login, password);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private boolean CreateDatabaseAndSetConnection(String DBName) {
        boolean flag = false;
        Connection dbConnection = null;
        try {
            dbConnection = this.setConnectionToServer(DBReaderWriter.path);
            String DBCreationQuery = "CREATE DATABASE IF NOT EXISTS " + DBReaderWriter.DBName;
            PreparedStatement preparedStatement = dbConnection.prepareStatement(DBCreationQuery);
            preparedStatement.executeUpdate();
            flag = true;
            dbConnection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    private boolean CreateProductsTable() {
        boolean flag = false;
        Connection dbConnection = null;
        try {
            dbConnection = this.setConnectionToServer(DBReaderWriter.fullConnection);
            String DBCreationQuery = "CREATE TABLE IF NOT EXISTS products" +
                    "(productID INT AUTO_INCREMENT NOT NULL, " +
                    "productName VARCHAR(45) NOT NULL, " +
                    "  priceForUnit DOUBLE NOT NULL, " +
                    "  unit INT NOT NULL, " +
                    "  available BIT(1) NOT NULL, " +
                    "  PRIMARY KEY (productID)  );";

            PreparedStatement preparedStatement = dbConnection.prepareStatement(DBCreationQuery);
            preparedStatement.executeUpdate();
            flag = true;
            dbConnection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    private boolean CreateMealsTable() {
        boolean flag = false;
        Connection dbConnection = null;
        try {
            dbConnection = this.setConnectionToServer(DBReaderWriter.fullConnection);
            String DBCreationQuery = "CREATE TABLE IF NOT EXISTS meals" +
                    "  (mealID INT AUTO_INCREMENT NOT NULL, " +
                    "  mealName VARCHAR(45) NOT NULL, " +
                    "  category  VARCHAR(45) NOT NULL, " +
                    "  price DOUBLE NOT NULL, " +
                    "  cost DOUBLE NOT NULL, " +
                    "  unit INT NOT NULL, " +
                    "  availability BIT(1) NOT NULL, " +
                    "  PRIMARY KEY (mealID));";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(DBCreationQuery);
            preparedStatement.executeUpdate();
            flag = true;
            dbConnection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    private boolean CreateMealItemsTable() {
        boolean flag = false;
        Connection dbConnection = null;
        try {
            dbConnection = this.setConnectionToServer(DBReaderWriter.fullConnection);
            String DBCreationQuery = "CREATE TABLE IF NOT EXISTS mealitems" +
                    "  (mealItemID INT AUTO_INCREMENT NOT NULL, " +
                    "  mealID INT NOT NULL, " +
                    "  productID INT NOT NULL, " +
                    "  quantity INT NOT NULL, " +
                    "  PRIMARY KEY (mealItemID)," +
                    "  FOREIGN KEY (mealID) REFERENCES meals(mealID) " +
                    "  ON UPDATE CASCADE " +
                    "  ON DELETE CASCADE, " +
                    "  FOREIGN KEY (productID) REFERENCES products(productID)" +
                    "  ON UPDATE CASCADE " +
                    "  ON DELETE CASCADE);";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(DBCreationQuery);
            preparedStatement.executeUpdate();
            flag = true;
            dbConnection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public boolean CreateNeededTables() {
        boolean flag = false;
        try {
            this.setConnectionToServer(DBReaderWriter.path);
            this.CreateDatabaseAndSetConnection(DBReaderWriter.DBName);
            this.CreateProductsTable();
            this.CreateMealsTable();
            this.CreateMealItemsTable();
            flag = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }


}

