package com.example.allinall;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

    @FXML
    private RadioButton Answer1;
    public RadioButton getAnswer1(){return Answer1;}

    @FXML
    private RadioButton Answer2;
    public RadioButton getAnswer2(){return Answer2;}

    @FXML
    private RadioButton Answer3;
    public RadioButton getAnswer3(){return Answer3;}

    @FXML
    private RadioButton Answer4;
    public RadioButton getAnswer4(){return Answer4;}

    @FXML
    private Text BlueText;

    @FXML
    private Text HelpText;

    @FXML
    private Pane Main;

    @FXML
    private Text NextQuestion;
    public Text getNextQuestion(){return NextQuestion;}

    @FXML
    private Text EndTest;

    @FXML
    private Text PrevQuestion;
    public Text getPrevQuestion(){return PrevQuestion;}

    @FXML
    private Text QuestionNumber;
    public Text getQuestionNumber(){return QuestionNumber;}

    @FXML
    private Label QuestionText;
    public Label getQuestionText(){return QuestionText;}

    @FXML
    public RadioButton[] array = new RadioButton[4];
    public RadioButton[] getArray()
    {
        array[0] = Answer1; array[1] = Answer2; array[2] = Answer3; array[3] = Answer4;
        Answer1.setWrapText(true);Answer2.setWrapText(true);Answer3.setWrapText(true);Answer4.setWrapText(true);
        return array;
    }


    //Этот кусок нужен был для первых тестов, вызывался нажатием на первый ответ, никак не используется/не вызывается, просто данные содержит
    @FXML
    public void Answer1(){
        Database connectNow = new Database();
        Connection connectDB = connectNow.getConnection();




        int QuestCount = 0, AnswerCount = 0;
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
        {
            try {
                String GetQuestCount = "SELECT Count(*) FROM base.otvetsperq where NUM_VOPR = '2'";
                Statement Count_Statement = connectDB.createStatement();
                ResultSet Count_output = Count_Statement.executeQuery(GetQuestCount);
                while (Count_output.next()) {
                    AnswerCount = Count_output.getInt("Count(*)");
                    System.out.println("Взятие количества ответов успешно");
                }
            } catch (Exception exp) {
                System.out.println("Взятие количества ответов не удалось, проверьте запрос");
            }
        } //узнать количество вариантов ответа
        QuestionNumber.setText("Вопрос №"+QuestCount);
        QuestionText.setWrapText(true);
        {
            try {
                String GetQuestion = "Select VOPROS FROM base.question where NUM = '" + QuestCount + "'"; //'1'";
                Statement statement = connectDB.createStatement();
                ResultSet output = statement.executeQuery(GetQuestion);
                while (output.next()) {
                    String text = output.getString("VOPROS");
                    QuestionText.setText(text);
                    System.out.println("Подстановка вопроса успешна");
                }
            } catch (Exception exp) {
                System.out.println("Подстановка вопроса не выполнена, проверьте запрос");
            }
        }//подставить текст вопроса
        for(int i =0; i<AnswerCount; i++)
        {
            try
            {
                String Answer_text = "SELECT Otvettxt FROM base.otvetsperq where NUM_VOPR = '"+QuestCount+"' AND num_otv = '" +(i+1)+"'";
                Statement statement_Answer = connectDB.createStatement();
                ResultSet Answer_output = statement_Answer.executeQuery(Answer_text);
                while (Answer_output.next())
                {
                    String text = Answer_output.getString("Otvettxt");
                    array[i].setText(text);
                    System.out.println("Подстановка ответа успешна");
                }
            }
            catch (Exception exp)
            {
                System.out.println("Подстановка ответа не выполнена, проверьте запрос");
            }
            if(AnswerCount ==2)
            {
                array[2].setVisible(false);
                array[3].setVisible(false);
            }
        }//подставить варианты ответа
    }



}

