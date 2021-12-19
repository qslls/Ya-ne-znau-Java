package com.example.allinall;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Back.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1139, 711);

        Controller ctrl = fxmlLoader.getController();
        Database connectNow = new Database();

        Connection connectDB = connectNow.getConnection();
        Statement statement = connectDB.createStatement();
        String DataBaseName = connectNow.getDataBaseName();

        int First = 1, AmountOfButtons = ctrl.GetAmountOfButtons();
        int NUM = 1, Password = 1234; //номер студента и пароль, пишу здесь, т.к. нет возможности взять это с окна регистрации
        String Login = "Student", Name = "Ivan", Second_Name = "Ivanov", otchestvo = "Ivanovich";

        ToggleGroup Answers = new ToggleGroup();
        for(int i=0; i< AmountOfButtons; i++)
        {
            ctrl.getArray()[i].setToggleGroup(Answers);
        }
        ctrl.AnswerChange(Answers);
        ctrl.Changes(statement, DataBaseName, Answers, First, connectNow);
        ctrl.PasteAnswers(statement,  DataBaseName,connectNow,1, 2);//заполнение 15 вопросов нулями, чтобы учесть случай, когда студент не выбрал вариант ответа вовсе
        stage.setResizable(false);
        stage.setTitle("Kompetenzen");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args)
    {
        launch();
    }
}