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
import java.sql.Statement;
import java.sql.ResultSet;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Back.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1139, 711);

        Controller ctrl = fxmlLoader.getController();
        Database connectNow = new Database();
        Connection connectDB = connectNow.getConnection();

        int num = 1;
        ToggleGroup Answers = new ToggleGroup();
        for(int i=0; i< 4; i++)
        {
            ctrl.getArray()[i].setToggleGroup(Answers);
        }
        AnswerChange(Answers);
        TextChange(ctrl, connectDB, num);
        ChangeQuestion(ctrl, connectDB, num);

        stage.setResizable(false);
        stage.setTitle("Kompetenzen");
        stage.setScene(scene);
        stage.show();

    }
    public int GetQuestionCount(Connection connectDB)
    {
        int QuestCount = 0;
        {
            try {
                String GetQuestCount = "SELECT Count(*) FROM base.question";
                Statement Count_Statement = connectDB.createStatement();
                ResultSet Count_output = Count_Statement.executeQuery(GetQuestCount);
                while (Count_output.next()) {
                    QuestCount = Count_output.getInt("Count(*)");
                    System.out.println("Взятие количества вопросов успешно");
                }
            } catch (Exception exp) {
                System.out.println("Взятие количества вопросов не удалось, проверьте запрос");
            }
        } //узнать количество вопросов
        return QuestCount;
    }
    public void AnswerChange(ToggleGroup group)
    {
        group.selectedToggleProperty().addListener((changed, oldValue, newValue) -> {
            RadioButton selected = (RadioButton) newValue;
            selected.setStyle("-fx-background-color: #0071ae; -fx-text-fill: #FFFFFF;-fx-border-color: #C8C9CB;");
            RadioButton old = (RadioButton) oldValue;
            if(old != null)
            {
                old.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000;-fx-border-color: #C8C9CB;");
            }
        });
    }
    public void TextChange(Controller ctrl, Connection connectDB, int QuesNumber)
    {

        System.out.println("Работа вне контроллера");
        ctrl.getQuestionNumber().setText("Вопрос №"+QuesNumber);
        ctrl.getQuestionText().setWrapText(true);
        int AnswerCount =0;
        {
            try {
                String GetQuestCount = "SELECT Count(*) FROM base.otvetsperq where NUM_VOPR = '"+QuesNumber+"'";
                Statement Count_Statement = connectDB.createStatement();
                ResultSet Count_output = Count_Statement.executeQuery(GetQuestCount);
                while (Count_output.next()) {
                    AnswerCount = Count_output.getInt("Count(*)");
                    System.out.println("Взятие количества ответов успешно");
                }
            } catch (Exception exp) {
                System.out.println("Взятие количества ответов не удалось, проверьте запрос");
            }
        } //количество вариантов ответа
        {
            try {
                String GetQuestion = "Select VOPROS FROM base.question where NUM = '" + QuesNumber + "'"; //'1'";
                Statement statement = connectDB.createStatement();
                ResultSet output = statement.executeQuery(GetQuestion);
                while (output.next()) {
                    String text = output.getString("VOPROS");
                    ctrl.getQuestionText().setText(text);
                    System.out.println("Подстановка вопроса успешна");
                }
            } catch (Exception exp) {
                System.out.println("Подстановка вопроса не выполнена, проверьте запрос");
            }
        }//подставить текст вопроса
        if(AnswerCount == 2)
        {
            ctrl.getArray()[2].setVisible(false);
            ctrl.getArray()[3].setVisible(false);
        }
        else
        {
            ctrl.getArray()[2].setVisible(true);
            ctrl.getArray()[3].setVisible(true);
        }
        for(int i =0; i<AnswerCount; i++)
        {
            try
            {
                String Answer_text = "SELECT Otvettxt FROM base.otvetsperq where NUM_VOPR = '"+QuesNumber+"' AND num_otv = '" +(i+1)+"'";
                Statement statement_Answer = connectDB.createStatement();
                ResultSet Answer_output = statement_Answer.executeQuery(Answer_text);
                while (Answer_output.next())
                {
                    String text = Answer_output.getString("Otvettxt");
                    ctrl.getArray()[i].setText(text);
                    System.out.println("Подстановка ответа успешна");
                }
            }
            catch (Exception exp)
            {
                System.out.println("Подстановка ответа не выполнена, проверьте запрос");
            }
        }//подставить варианты ответа
    }
    public void ChangeQuestion(Controller ctrl, Connection connectDB, int number)
    {
        if(number < GetQuestionCount(connectDB))
        {
            ctrl.getNextQuestion().setOnMouseClicked(mouseEvent ->
            {
                int newnumber = number;
                newnumber++;
                TextChange(ctrl, connectDB, newnumber);
                ChangeQuestion(ctrl, connectDB, newnumber);
            });
        }
        if(number > 1)
        {
            ctrl.getPrevQuestion().setOnMouseClicked(mouseEvent ->
            {
                int newnumber = number;
                newnumber--;
                TextChange(ctrl, connectDB, newnumber);
                ChangeQuestion(ctrl, connectDB, newnumber);
            });
        }
    }



    public static void main(String[] args)
    {
        launch();
    }
}