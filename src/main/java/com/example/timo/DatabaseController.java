package com.example.timo;
import java.sql.*;

public class DatabaseController {

    public void SavePresentGame(String game,int checks) throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timodb","root","200041156");
        String sql="insert into datatable(gamestring,checks) values(?,?)";
//        System.out.println(game+checks);
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setString(1,game);
        statement.setInt(2,checks);
        statement.executeUpdate();
        System.out.println("Inserted");

//        while (resultSet.next()){
//            System.out.println(resultSet.getString(1)+resultSet.getInt(2)+resultSet.getInt(3));
//        }

    }
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
