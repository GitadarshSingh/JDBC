import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUPDATEDemo {
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
//            String query = "select * from students"; //It is not a query it is a string

            //insert
            String  query =  "update students set age = '25' where id = 1";
            int update = statement.executeUpdate(query);
            System.out.println("Updated "+update+" rows");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
