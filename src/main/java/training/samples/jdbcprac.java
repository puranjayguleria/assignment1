package training.samples;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

public class jdbcprac {

	                public static void createTable() {
	                                Connection con = null;
	                                Statement stmt = null;
	                                int result = 0;
	                                try {
	                                                Class.forName("org.hsqldb.jdbcDriver");
	                                                con = DriverManager.getConnection("jdbc:hsqldb:mem:training", "SA", "");
	                                                stmt = con.createStatement();

	                                                result = stmt.executeUpdate(
	                                                                                "CREATE TABLE USERDETAILS (id INT NOT NULL, USER_NAME VARCHAR(50) NOT NULL, USER_ID VARCHAR(50) NOT NULL, EMAIL VARCHAR(50) NOT NULL, DEPT VARCHAR(50) NOT NULL, ADDRESS VARCHAR(255) NOT NULL, PRIMARY KEY (id)); ");

	                                } catch (Exception e) {
	                                                e.printStackTrace(System.out);
	                                }
	                                System.out.println("Table created successfully");

	}
	                public static void updateUser(Integer ID, String userid) {

	                                Connection conn = null;
	                                Statement stmt = null;
	                                try {
	                                                // STEP 2: Register JDBC driver
	                                                Class.forName("org.hsqldb.jdbcDriver");

	                                                // STEP 3: Open a connection
	                                                System.out.println("Connecting to a selected database...");
	                                                conn = DriverManager.getConnection("jdbc:hsqldb:mem:training", "SA", "");
	                                                System.out.println("Connected database successfully...");

	                                                // STEP 4: Execute a query
	                                                System.out.println("Creating statement...");
	                                                stmt = conn.createStatement();
	                                                String sql = "UPDATE USERDETAILS SET USER_ID ="+userid +"  WHERE id = " + ID;
	                                                stmt.executeUpdate(sql);

	                                                
	                                } catch (SQLException se) {
	                                                // Handle errors for JDBC
	                                                se.printStackTrace();
	                                } catch (Exception e) {
	                                                // Handle errors for Class.forName
	                                                e.printStackTrace();
	                                } finally {
	                                                // finally block used to close resources
	                                                try {
	                                                                if (stmt != null)
	                                                                                conn.close();
	                                                } catch (SQLException se) {
	                                                } // do nothing
	                                                try {
	                                                                if (conn != null)
	                                                                                conn.close();
	                                                } catch (SQLException se) {
	                                                                se.printStackTrace();
	                                                } // end finally try
	                                } // end try

	                }
	                public static void listUsers() {
	                                Connection conn = null;
	                                
	                                String db = "jdbc:hsqldb:mem:training";
	                                String user = "SA";
	                                String password = "";

	                                try {

	                                                Class.forName("org.hsqldb.jdbcDriver");

	                                                // Create database connection
	                                                conn = DriverManager.getConnection(db, user, password);

	                                                // Create and execute statement
	                                                Statement stmt = conn.createStatement();
	                                                ResultSet rs = stmt.executeQuery("select id, USER_NAME, USER_ID, EMAIL, DEPT ,ADDRESS from USERDETAILS");
	                                                if(rs.getRow()==0) {
	                                                                System.out.println("No rows available");
	                                                }
	                                                // Loop through the data and print all artist names
	                                                while (rs.next()) {
	                                                                System.out.println("Customer Details: " + rs.getInt("id")+" " +rs.getString("USER_NAME") + " " + rs.getString("USER_ID")
	                                                                                                + " " + rs.getString("EMAIL")+" "+ rs.getString("DEPT")+" "+ rs.getString("ADDRESS"));
	                                                }
	                                                
	                                                // Clean up
	                                                rs.close();
	                                                stmt.close();
	                                } catch (SQLException e) {
	                                                System.err.println(e.getMessage());
	                                } catch (Exception e) {
	                                                System.err.println(e.getMessage());
	                                } finally {
	                                                try {
	                                                                // Close connection
	                                                                if (conn != null)
	                                                                                conn.close();
	                                                } catch (SQLException e) {
	                                                                System.err.println(e.getMessage());
	                                                }
	                                }
	                }
	                public static void deleteUser(Integer ID) {

	                                Connection conn = null;
	                                Statement stmt = null;
	                                try {
	                                                // STEP 2: Register JDBC driver
	                                                Class.forName("org.hsqldb.jdbcDriver");

	                                                // STEP 3: Open a connection
	                                                System.out.println("Connecting to a selected database...");
	                                                conn = DriverManager.getConnection("jdbc:hsqldb:mem:training", "SA", "");
	                                                System.out.println("Connected database successfully...");

	                                                // STEP 4: Execute a query
	                                                System.out.println("Creating statement...");
	                                                stmt = conn.createStatement();
	                                                String sql = "DELETE FROM USERDETAILS  WHERE id = " + ID;
	                                                stmt.executeUpdate(sql);

	                                                
	                                } catch (SQLException se) {
	                                                // Handle errors for JDBC
	                                                se.printStackTrace();
	                                } catch (Exception e) {
	                                                // Handle errors for Class.forName
	                                                e.printStackTrace();
	                                } finally {
	                                                // finally block used to close resources
	                                                try {
	                                                                if (stmt != null)
	                                                                                conn.close();
	                                                } catch (SQLException se) {
	                                                } // do nothing
	                                                try {
	                                                                if (conn != null)
	                                                                                conn.close();
	                                                } catch (SQLException se) {
	                                                                se.printStackTrace();
	                                                } // end finally try
	                                } // end try
	                                System.out.println("Row Deleted from the table!");

	                }
	                public static void addUser(Integer Id, String userName, String userId, String email, String dept, String address ) {

	                                Connection conn = null;
	                                Statement stmt = null;
	                                try {
	                                
	                                                Class.forName("org.hsqldb.jdbcDriver");

	                                                
	                                                System.out.println("Connecting to a selected database...");
	                                                conn = DriverManager.getConnection("jdbc:hsqldb:mem:training", "SA", "");
	                                                System.out.println("Connected database successfully...");
	                                                System.out.println("Inserting records into the table...");
	                                                stmt = conn.createStatement();

	                                                String sql = "INSERT INTO USERDETAILS (id, USER_NAME, USER_ID, EMAIL, DEPT ,ADDRESS) " + "VALUES (" + Id + ", '"
	                                                                                + userName + "', '" + userId + "','" + email + "','" + dept + "','" + address + "')";

	                                                stmt.executeUpdate(sql);

	                                                System.out.println("Inserted records into the table...");

	                                } catch (SQLException se) {
	                                
	                                                se.printStackTrace();
	                                } catch (Exception e) {
	                                                
	                                                e.printStackTrace();
	                                } finally {
	                                                
	                                                try {
	                                                                if (stmt != null)
	                                                                                conn.close();
	                                                } catch (SQLException se) {
	                                                } 
	                                                try {
	                                                                if (conn != null)
	                                                                                conn.close();
	                                                } catch (SQLException se) {
	                                                                se.printStackTrace();
	                                                } 
	                                } 
	                }

	                public static void main(String[] args) {

	                                createTable();
	                                listUsers();
	                                addUser(1, "Puranjay", "10367","cpuranjay@gmail.com","code dev","patrika nagar");
	                                addUser(2, "ishnav", "10367","ag.com","code dev","patrika nagar");
	                                addUser(3, "girdhari", "10367","ag.com","code dev","patrika nagar");
	                                listUsers();
	                                updateUser(1,"10988");
	                                listUsers();
	                                deleteUser(1);
	                                listUsers();
	                }
	}
	

