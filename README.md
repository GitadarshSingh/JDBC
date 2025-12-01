JDBC

──────────────────────────────────────────
[== OVERVIEW ==]
Direct SQL execution from Java using the JDBC API. Provides connection handling, statement execution, CRUD operations, and scroll-oriented result navigation.

──────────────────────────────────────────
[== FEATURES ==]
▣ CRUD operations
▣ Prepared statements
▣ Scroll-insensitive and scroll-sensitive navigation
▣ Auto-commit control
▣ Exception diagnostics

──────────────────────────────────────────
[== REQUIREMENTS ==]
▣ Java 8+
▣ MySQL 8.x
▣ MySQL Connector/J

──────────────────────────────────────────
[== SETUP ==]

Install MySQL

Create schema demo

Create required tables

Add MySQL Connector/J to classpath

Compile and run Java sources

──────────────────────────────────────────
[== CONNECTION TEMPLATE ==]

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/demo",
    "root",
    "password"
);


──────────────────────────────────────────
[== BASIC QUERY ==]

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM students");

while (rs.next()) {
    int id = rs.getInt("id");
    String name = rs.getString("stdname");
}


──────────────────────────────────────────
[== INSERT (PREPARED STATEMENT) ==]

String q = "INSERT INTO students(id, stdname) VALUES (?, ?)";
PreparedStatement ps = con.prepareStatement(q);
ps.setInt(1, 1);
ps.setString(2, "Adarsh");
ps.executeUpdate();


──────────────────────────────────────────
[== UPDATE ==]

String q = "UPDATE students SET stdname=? WHERE id=?";
PreparedStatement ps = con.prepareStatement(q);
ps.setString(1, "NewName");
ps.setInt(2, 1);
ps.executeUpdate();


──────────────────────────────────────────
[== SCROLL NAVIGATION ==]

Statement st = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY
);

ResultSet rs = st.executeQuery("SELECT * FROM students");

rs.last();
rs.first();
rs.absolute(2);


──────────────────────────────────────────
[== EXCEPTION NOTES ==]
▣ Type mismatch → SQLDataException
▣ Invalid table name → SQLSyntaxErrorException
▣ Driver missing → ClassNotFoundException

──────────────────────────────────────────
[== DIRECTORY STRUCTURE ==]

JDBC/
 ├── src/
 │    ├── JDBCdemo.java
 │    ├── JDBCinsertDemo.java
 │    ├── JDBCUPDATEDemo.java
 │    ├── JDBCdeleteDemo.java
 │    ├── scrollinsensitive.java
 │    └── scrollinsensitivedemo.java
 └── README.md
