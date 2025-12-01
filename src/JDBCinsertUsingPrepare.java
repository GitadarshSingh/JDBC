import java.sql.*;

public class JDBCinsertUsingPrepare {
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


            //insert
            String  query =  "insert into students(id, stdname, age) values (?,?,?)";
            PreparedStatement pstmt  = con.prepareStatement(query);
           pstmt.setInt(1,101);
           pstmt.setString(2,"Ankit");
           pstmt.setInt(3,13);

           int update = pstmt.executeUpdate();
            System.out.println("rows updated "+ update);


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
