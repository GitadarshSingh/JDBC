import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdeleteDemo {
    /* 1. load the driver class
       2. Get connection from db
       3. Create Statement
       4.String Query
     **/
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //load driver class -> RUN TIME PAR JO BHI LIKHOGE OH LOAD HO JAYGA
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "root", "adarsh1234");
            Statement statement = con.createStatement();

            //update
            String  query =  "delete from students where id = 6 ";
            int delete = statement.executeUpdate(query);
            System.out.println("Updated "+delete+" rows");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
