package com.tyss.jbdc.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcClass implements JdbcInterface {



@Override
public void insert(int sid, String sname) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdb?user=root&password=root@123");
String query = "insert into student values(?,?);";
PreparedStatement pm = con.prepareStatement(query);
pm.setInt(1, sid);
pm.setString(2, sname);

pm.execute();
con.close();
}catch (Exception e) {
e.getMessage();
}




}

@Override
public ArrayList<Object> select() {
ArrayList<Object> obj=null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdb?user=root&password=root@123");
    String query = "select * from student";
    Statement stmt = con.createStatement();
   ResultSet rs= stmt.executeQuery(query);
   obj = new ArrayList<Object>();
   while(rs.next())
   {
    int i1= rs.getInt("sid");
    obj.add(i1);
    String s1 = rs.getString("sname");
    obj.add(s1);
   }
   

   con.close();
} catch (Exception e) {
e.getMessage();
}

return obj;
}

@Override
public void update(int sid, String sname) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdb?user=root&password=root@123");
    String query = "upadte student set sname=? where sid=?;";
PreparedStatement pm = con.prepareStatement(query);
pm.setString(1, sname);
pm.setInt(2, sid);


pm.execute();
con.close();
} catch (Exception e) {
e.getMessage();
}

}

@Override
public void delete(int sid) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdb?user=root&password=root@123");
    String query = "delete from student where sid=?;";
PreparedStatement pm = con.prepareStatement(query);

pm.setInt(1, sid);


pm.execute();
con.close();
} catch (Exception e) {
e.getMessage();
}

}



}