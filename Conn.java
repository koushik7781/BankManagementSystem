
//There are 5 Steps in Java Database Connectivity 
//1.Register the Driver
//2.Create Connection 
//3.Create Statement 
//4.Execute Query
//5.Close connection

// Step 1 \sql
// Step 2 \connect root@localhost





package bank.management.system;
import java.sql.*;

public class Conn{
        Connection c;
        Statement s;
       public Conn() {
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","QWERTyuiop@1");
               s = c.createStatement();
           }catch(Exception e)
           {
               System.out.println(e);
           }
       }
}