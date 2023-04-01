package com.example.timo;
import java.sql.*;

public class StatisticsController {
    public String GetPrevGame() throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timodb","root","200041156");
        String sql="select gamestring from datatable";
//        System.out.println(game+checks);
        Statement statement=con.createStatement();

        ResultSet rst=statement.executeQuery(sql);
        String str="";
        while (rst.next()) {
            str = rst.getString(1);
        }
        System.out.println(str);
        return  str;
    }
}
