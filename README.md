Overview

Direct SQL execution from Java using the JDBC API. Implements connection handling, statement execution, CRUD operations, and scroll-based result navigation.

Features

• CRUD operations
• Prepared statements
• Scroll-insensitive and scroll-sensitive navigation
• Auto-commit control
• Basic exception diagnostics

Requirements

• Java 8+
• MySQL 8.x
• MySQL Connector/J

Setup

Install MySQL.

Create schema demo.

Create required tables.

Add MySQL Connector/J to the classpath.

Compile and run the Java sources.

Connection Template
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/demo",
    "root",
    "password"
);

Basic Query
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM students");
while (rs.next()) {
    int id = rs.getInt("id");
    String name = rs.getString("stdname");
}

Insert (PreparedStatement)
String q = "INSERT INTO students(id, stdname) VALUES (?, ?)";
PreparedStatement ps = con.prepareStatement(q);
ps.setInt(1, 1);
ps.setString(2, "Adarsh");
ps.executeUpdate();

Update
String q = "UPDATE students SET stdname=? WHERE id=?";
PreparedStatement ps = con.prepareStatement(q);
ps.setString(1, "NewName");
ps.setInt(2, 1);
ps.executeUpdate();

Scroll Navigation
Statement st = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY
);

ResultSet rs = st.executeQuery("SELECT * FROM students");

rs.last();
rs.first();
rs.absolute(2);

Exception Notes

• Type mismatches → SQLDataException
• Wrong table names → SQLSyntaxErrorException
• Missing driver → ClassNotFoundException

Directory Structure
JDBC/
 ├── src/
 │    ├── JDBCdemo.java
 │    ├── JDBCinsertDemo.java
 │    ├── JDBCUPDATEDemo.java
 │    ├── JDBCdeleteDemo.java
 │    ├── scrollinsensitive.java
 │    └── scrollinsensitivedemo.java
 └── README.md
