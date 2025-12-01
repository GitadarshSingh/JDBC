import java.sql.*;

public class scrollinsensitive {
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
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           String query = "select * from students";
            ResultSet rs = statement.executeQuery(query);
            System.out.println("--------------Read Data-------------");

            rs.last();
            System.out.println("Last Row: "+rs.getInt("id"));
            System.out.println("Last Row: "+rs.getString("stdname"));

            rs.first();
            System.out.println("First Row: "+rs.getInt("id"));
            System.out.println("First Row: "+rs.getString("stdname"));

            rs.absolute(2);
            System.out.println("Row 2: "+rs.getInt("id"));
            System.out.println("Row 2: "+rs.getString("stdname"));



        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
