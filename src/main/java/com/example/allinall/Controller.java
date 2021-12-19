package com.example.allinall;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DecimalFormat;


public class Controller
{

    private final int CircleRadius = 5; // Радиус кружков индикатора
    private final int CircleOffsetFac = 15; // Отступ между кружками индикатора

    @FXML
    private RadioButton Answer1;

    @FXML
    private RadioButton Answer2;

    @FXML
    private RadioButton Answer3;

    @FXML
    private RadioButton Answer4;

    @FXML
    private Text RightAnswers;
    public Text getRightAnswers(){return RightAnswers;}

    @FXML
    private Pane Background;
    public Pane getBackground(){return Background;}
    @FXML
    private Pane CircleArea;
    @FXML
    private Pane ResultPane;
    public Pane getResultPane(){return ResultPane;}
    @FXML
    private Pane Result;
    public Pane getResult(){return Result;}
    @FXML
    private Pane Main;
    public Pane getMainPane(){return Main;}

    @FXML
    private Text NextQuestion;
    public Text getNextQuestion(){return NextQuestion;}

    @FXML
    private Text EndTest;
    public Text getEndTest(){return EndTest;}
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
    @FXML
    private Circle[] Circles;


    public int GetAmountOfButtons()
    {
        return 4;//для последующей гибкости
    }
    public int GetNumberOfActivePosition()
    {
        int max = GetAmountOfButtons(), Active = 0;
        for(int i=0; i< max; i++)
        {
            if(getArray()[i].isSelected())
            {
                Active = i+1;
            }
        }
        return Active;
    }
    public void UpdateAnswerStatus(Statement stt, String DataBaseName, int Answer, int QuestionNumber)
    {
        if(GetNumberOfActivePosition() !=0) {
            try {
                String PasteAsk = "UPDATE " + DataBaseName + ".stata_pertest SET Otvet_student = " + Answer + " WHERE Num_vopr = " + QuestionNumber;
                stt.executeUpdate(PasteAsk);
                System.out.println("Изменение ответа успешна");
            } catch (Exception exp) {
                System.out.println("Изменение ответа не удалась, проверьте запрос");
            }//изменить запись
        }
    }
    public void AnswerChange(ToggleGroup group)
    {
        group.selectedToggleProperty().addListener((changed, oldValue, newValue) -> {
            RadioButton selected = (RadioButton) newValue;
            if (selected != null)
            {
                selected.setStyle("-fx-border-color: #0071ae;");
            }
            RadioButton old = (RadioButton) oldValue;
            if (old != null)
            {
                old.setStyle("-fx-border-color: #C8C9CB;");
            }
        });

    }
    public void TextChange(Statement stt, String DataBaseName, int QuesNumber, ToggleGroup group)
    {

        if(group.getSelectedToggle() != null)
        {
            group.getSelectedToggle().setSelected(false);
        }
        System.out.println("Работа вне контроллера");
        getQuestionNumber().setText("Вопрос №"+QuesNumber);
        getQuestionText().setWrapText(true);
        int AnswerCount =0;
        {
            try {
                String GetQuestCount = "SELECT Count(*) FROM " +DataBaseName+".otvetsperq where NUM_VOPR = '"+QuesNumber+"'";
                ResultSet Count_output = stt.executeQuery(GetQuestCount);
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
                String GetQuestion = "Select VOPROS FROM " +DataBaseName+ ".question where NUM = '" + QuesNumber + "'"; //'1'";
                ResultSet output = stt.executeQuery(GetQuestion);
                while (output.next()) {
                    String text = output.getString("VOPROS");
                    getQuestionText().setText(text);
                    System.out.println("Подстановка вопроса успешна");
                }
            } catch (Exception exp) {
                System.out.println("Подстановка вопроса не выполнена, проверьте запрос");
            }
        }//подставить текст вопроса
        if(AnswerCount == 2)
        {
            getArray()[2].setVisible(false);
            getArray()[3].setVisible(false);
        }
        else
        {
            getArray()[2].setVisible(true);
            getArray()[3].setVisible(true);
        }
        for(int i =0; i<AnswerCount; i++)
        {
            try
            {
                String Answer_text = "SELECT Otvettxt FROM " +DataBaseName+".otvetsperq where NUM_VOPR = '"+QuesNumber+"' AND num_otv = '" +(i+1)+"'";
                ResultSet Answer_output = stt.executeQuery(Answer_text);
                while (Answer_output.next())
                {
                    String text = Answer_output.getString("Otvettxt");
                    getArray()[i].setText(text);
                    System.out.println("Подстановка ответа успешна");
                }
            }
            catch (Exception exp)
            {
                System.out.println("Подстановка ответа не выполнена, проверьте запрос");
            }
        }//подставить варианты ответа
    }
    public void Changes(Statement stt, String DataBaseName, ToggleGroup group, int newnumber, Database DB)
    {
        TextChange(stt, DataBaseName, newnumber, group);
        if(GetQuestionInfo(stt, DataBaseName, newnumber) != 0) {
            getArray()[GetQuestionInfo(stt, DataBaseName, newnumber) - 1].setSelected(true);
        }
        ChangeQuestion(newnumber, group, stt,DB, DataBaseName);
    }
    public int GetRightAnswers(Statement stt, Database DB, String DataBaseName)
    {
        int Points = 0, max = DB.GetPrimaryQuestionCount(stt), RightAnswer=-1, UserAnswer;
        for(int i = 0; i< max; i++)
        {
            try {
                String GetQuestCount = "SELECT num_otv FROM " +DataBaseName+ ".otvetsperq WHERE Pravilnost = 1 AND NUM_VOPR = "+(i+1);
                ResultSet Right_output = stt.executeQuery(GetQuestCount);
                while (Right_output.next()) {
                    RightAnswer = Right_output.getInt("num_otv");
                    System.out.println("Взятие правильного ответа успешно");
                }
            } catch (Exception exp) {
                System.out.println("Взятие правильного ответа не удалось, проверьте запрос");
            }
            UserAnswer = GetQuestionInfo(stt, DataBaseName,i+1);
            if(RightAnswer == UserAnswer)
            {
                Points++;
            }
        }
        return Points;
    }
    public int GetQuestionInfo(Statement stt, String DataBaseName, int Question)
    {
        int UserAnswer=0;
        try {
            String GetQuestCount = "SELECT Otvet_student FROM "+DataBaseName+ ".stata_pertest where Num_vopr = "+Question;
            ResultSet Right_output = stt.executeQuery(GetQuestCount);
            while (Right_output.next()) {
                UserAnswer = Right_output.getInt("Otvet_student");
                System.out.println("Взятие пользовательского ответа успешно");
            }
        } catch (Exception exp) {
            System.out.println("Взятие пользовательского ответа не удалось, проверьте запрос");
        }
        return UserAnswer;
    }
    public void ChangeQuestion(int number, ToggleGroup group, Statement stt, Database DB, String DataBaseName)
    {

        int max = DB.GetPrimaryQuestionCount(stt);
        if(number < max)
        {
            getNextQuestion().setOnMouseClicked(mouseEvent ->
            {

                UpdateAnswerStatus(stt, DataBaseName, GetNumberOfActivePosition(),number);
                int newnumber = number;//это номер вопроса, не забывай, еблан
                newnumber++;
                //circle.setNextActiveCircle(number-1);
                Changes(stt, DataBaseName, group,newnumber, DB);

            });
        }
        if(number > 1)
        {
            getPrevQuestion().setOnMouseClicked(mouseEvent ->
            {
                //circle.setPrevActiveCircle(number-1);
                UpdateAnswerStatus(stt, DataBaseName, GetNumberOfActivePosition(),number);
                int newnumber = number;
                newnumber--;
                Changes(stt, DataBaseName, group,newnumber, DB);

            });
        }
        getEndTest().setOnMouseClicked(mouseEvent ->
        {
            {
                final Stage dialogStage = new Stage();
                dialogStage.setHeight(150);
                dialogStage.setTitle("Завершение теста");
                dialogStage.setAlwaysOnTop(true);
                Label exitLabel = new Label("Вы действительно хотите завершить тестирование?\n\t\tВаши ответы будут сохранены.");
                dialogStage.setResizable(false);
                dialogStage.initStyle(StageStyle.UTILITY);

                Button yesBtn = new Button("Да");
                yesBtn.setOnAction(arg0 ->
                {
                    dialogStage.close();
                    float percent;String Result;
                    percent = ((float)GetRightAnswers(stt, DB, DataBaseName) / (float)DB.GetPrimaryQuestionCount(stt)) * 100;
                    DecimalFormat myFormatter = new DecimalFormat("#.00");
                    Result = myFormatter.format(percent);
                    UpdateAnswerStatus(stt, DataBaseName, GetNumberOfActivePosition(),number);
                    getMainPane().setVisible(false);getResult().setVisible(true);
                    getRightAnswers().setText("Правильных ответов: "+GetRightAnswers(stt, DB, DataBaseName)+ " ("+Result+"%)");
                    getBackground().setStyle("-fx-background-color: #8a8f99;");
                    DB.UpdatePrimaryStatus(stt, DataBaseName, percent, 1);
                });
                Button noBtn = new Button("Нет");

                noBtn.setOnAction(arg0 -> dialogStage.close());

                HBox hBox = new HBox();
                hBox.setAlignment(Pos.BASELINE_CENTER);
                hBox.setSpacing(40.0);
                hBox.getChildren().addAll(yesBtn, noBtn);

                VBox vBox = new VBox();
                vBox.setSpacing(40.0);
                vBox.getChildren().addAll(exitLabel, hBox);

                dialogStage.setScene(new Scene(vBox));
                dialogStage.show();

            }

        });
        getNextQuestion().setVisible(number != max);//убрать последнюю кнопку
        getPrevQuestion().setVisible(number != 1);//убрать первую кнопку
    }
    public void PasteAnswers(Statement stt, String DataBaseName, Database DB, int Num_student, int Num_popytki)
    {
        int max = DB.GetPrimaryQuestionCount(stt);
        for (int i = 0; i < max; i++) {
            try {
                String PasteAsk = "INSERT INTO " + DataBaseName + ".stata_pertest(Num_vopr, Num_student, Otvet_student, Num_popytki) VALUES (" + (i + 1) + "," + Num_student + "," + 0 + "," + Num_popytki + ")";
                stt.executeUpdate(PasteAsk);
                System.out.println("Вставка ответа успешна");
            } catch (Exception exp) {
                System.out.println("Вставка ответа не удалась, проверьте запрос");
            }//создать запись
        }
    }
    @FXML
    void initialize() throws SQLException {
        Database connectNow = new Database();
        Connection connectDB = connectNow.getConnection();
        Statement statement = connectDB.createStatement();
        String DataBaseName = connectNow.getDataBaseName();

        final int TaskCount =connectNow.GetPrimaryQuestionCount(statement);
        final int CircleCount = TaskCount;
        Result.setVisible(false);
        CircleArea.setPrefWidth(CircleCount * CircleOffsetFac - CircleRadius);
    }
}

