package com.example.timo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class StatisticsController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button Refresh=new Button();
    @FXML
    private Button Back=new Button();
    @FXML
    private Label total=new Label();
    @FXML
    public void OnRefreshClicked() throws SQLException {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/timodb","root","200041156");
        String sql="select count(gamestring) from datatable";
        Statement statement=con.createStatement();
        ResultSet rst=statement.executeQuery(sql);
        int str=0;
        while (rst.next()) {
            str = rst.getInt(1);
        }

        System.out.println(str);
        total.setText(Integer.toString(str));
        System.out.println(str);
    }
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Timo-view.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root,760,690);
        stage.setTitle("Timo");
        stage.setScene(scene);
        stage.show();
    }
}
