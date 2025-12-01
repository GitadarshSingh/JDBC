import java.sql.*;

public class JDBCdemo {
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
            String query = "select * from students"; //It is not a query it is a string
            ResultSet rs = statement.executeQuery(query);
            System.out.println("--------------Read Data-------------");
            while(rs.next())
            {
                System.out.println(
                        rs.getInt("id")+"|"+
                        rs.getString("stdname")+"|"+
                        rs.getInt("age")
                );
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
