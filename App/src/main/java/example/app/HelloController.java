package example.app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private AnchorPane AnchorScreen;

    @FXML
    private Pane QuestionPane;
    @FXML
    private Text QuestionNumber;
    @FXML
    private Pane AnswerPane;
    @FXML
    private RadioButton Answer1;
    @FXML
    private RadioButton Answer2;
    @FXML
    private RadioButton Answer3;
    @FXML
    private RadioButton Answer4;


    @FXML
    private Pane QuestionPane1;
    @FXML
    private Pane AnswerPane1;
    @FXML
    private Text QuestionNumber_1;
    @FXML
    private RadioButton Answer1_1;
    @FXML
    private RadioButton Answer2_1;
    @FXML
    private RadioButton Answer3_1;
    @FXML
    private RadioButton Answer4_1;


    @FXML
    private Pane QuestionPane2;
    @FXML
    private Pane AnswerPane2;
    @FXML
    private Text QuestionNumber_2;
    @FXML
    private RadioButton Answer1_2;
    @FXML
    private RadioButton Answer2_2;
    @FXML
    private RadioButton Answer3_2;
    @FXML
    private RadioButton Answer4_2;


    @FXML
    private ScrollPane MainScreen;









    @FXML
    private Text Title;

    public void setAnswer1(String AnswerText)
    {
        Answer1.setText(AnswerText);
    }
    public RadioButton getAnswer1()
    {
        return Answer1;
    }

}