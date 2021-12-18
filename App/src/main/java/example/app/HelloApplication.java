package example.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Back.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 680, 560);
        stage.setTitle("SambrerUS");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();


        HelloController controller = fxmlLoader.getController();
        //группировка кнопок
        {
            ToggleGroup Question1 = new ToggleGroup();
            controller.getAnswer1().setToggleGroup(Question1);
            controller.getAnswer2().setToggleGroup(Question1);
            controller.getAnswer3().setToggleGroup(Question1);
            controller.getAnswer4().setToggleGroup(Question1);
            ColorChange(Question1);
        }
        {
            ToggleGroup Question_2 = new ToggleGroup();
            controller.getAnswer1_2().setToggleGroup(Question_2);
            controller.getAnswer2_2().setToggleGroup(Question_2);
            controller.getAnswer3_2().setToggleGroup(Question_2);
            controller.getAnswer4_2().setToggleGroup(Question_2);
            ColorChange(Question_2);
        }
        {
            ToggleGroup Question_3 = new ToggleGroup();
            controller.getAnswer1_3().setToggleGroup(Question_3);
            controller.getAnswer2_3().setToggleGroup(Question_3);
            ColorChange(Question_3);
        }
        {
            ToggleGroup Question_4 = new ToggleGroup();
            controller.getAnswer1_4().setToggleGroup(Question_4);
            controller.getAnswer2_4().setToggleGroup(Question_4);
            controller.getAnswer3_4().setToggleGroup(Question_4);
            controller.getAnswer4_4().setToggleGroup(Question_4);
            ColorChange(Question_4);
        }
        {
            ToggleGroup Question_5 = new ToggleGroup();
            controller.getAnswer1_5().setToggleGroup(Question_5);
            controller.getAnswer2_5().setToggleGroup(Question_5);
            controller.getAnswer3_5().setToggleGroup(Question_5);
            controller.getAnswer4_5().setToggleGroup(Question_5);
            ColorChange(Question_5);
        }
        {
            ToggleGroup Question_6 = new ToggleGroup();
            controller.getAnswer1_6().setToggleGroup(Question_6);
            controller.getAnswer2_6().setToggleGroup(Question_6);
            controller.getAnswer3_6().setToggleGroup(Question_6);
            controller.getAnswer4_6().setToggleGroup(Question_6);
            ColorChange(Question_6);
        }
        {
            ToggleGroup Question_7 = new ToggleGroup();
            controller.getAnswer1_7().setToggleGroup(Question_7);
            controller.getAnswer2_7().setToggleGroup(Question_7);
            controller.getAnswer3_7().setToggleGroup(Question_7);
            controller.getAnswer4_7().setToggleGroup(Question_7);
            ColorChange(Question_7);
        }
        {
            ToggleGroup Question_8 = new ToggleGroup();
            controller.getAnswer1_8().setToggleGroup(Question_8);
            controller.getAnswer2_8().setToggleGroup(Question_8);
            controller.getAnswer3_8().setToggleGroup(Question_8);
            controller.getAnswer4_8().setToggleGroup(Question_8);
            ColorChange(Question_8);
        }
        {
            ToggleGroup Question_9 = new ToggleGroup();
            controller.getAnswer1_9().setToggleGroup(Question_9);
            controller.getAnswer2_9().setToggleGroup(Question_9);
            ColorChange(Question_9);
        }
        {
            ToggleGroup Question_10 = new ToggleGroup();
            controller.getAnswer1_10().setToggleGroup(Question_10);
            controller.getAnswer2_10().setToggleGroup(Question_10);
            controller.getAnswer3_10().setToggleGroup(Question_10);
            controller.getAnswer4_10().setToggleGroup(Question_10);
            ColorChange(Question_10);
        }
        {
            ToggleGroup Question_11 = new ToggleGroup();
            controller.getAnswer1_11().setToggleGroup(Question_11);
            controller.getAnswer2_11().setToggleGroup(Question_11);
            controller.getAnswer3_11().setToggleGroup(Question_11);
            controller.getAnswer4_11().setToggleGroup(Question_11);
            ColorChange(Question_11);
        }
        {
            ToggleGroup Question_12 = new ToggleGroup();
            controller.getAnswer1_12().setToggleGroup(Question_12);
            controller.getAnswer2_12().setToggleGroup(Question_12);
            ColorChange(Question_12);
        }
        {
            ToggleGroup Question_13 = new ToggleGroup();
            controller.getAnswer1_13().setToggleGroup(Question_13);
            controller.getAnswer2_13().setToggleGroup(Question_13);
            controller.getAnswer3_13().setToggleGroup(Question_13);
            controller.getAnswer4_13().setToggleGroup(Question_13);
            ColorChange(Question_13);
        }
        {
            ToggleGroup Question_14 = new ToggleGroup();
            controller.getAnswer1_14().setToggleGroup(Question_14);
            controller.getAnswer2_14().setToggleGroup(Question_14);
            ColorChange(Question_14);
        }
        {
            ToggleGroup Question_15 = new ToggleGroup();
            controller.getAnswer1_15().setToggleGroup(Question_15);
            controller.getAnswer2_15().setToggleGroup(Question_15);
            controller.getAnswer3_15().setToggleGroup(Question_15);
            controller.getAnswer4_15().setToggleGroup(Question_15);
            ColorChange(Question_15);
        }
        //текст кнопок
        {
            controller.setAnswer(controller.getAnswer1(), "Команда проекта легко собирается вместе; Команда имеет единое представление о це-\nлях и задачах; Каждый член команды имеет личную заинтересованность в достижении\nцелей; Информация внутри команды передается быстро и без искажений; Единая сис-\nтема ценностей и единство правил внутри команды; Единый лидер, признанный коман-\nдой; Ответственность каждого члена команды определена.");
            controller.setAnswer(controller.getAnswer2(), "Команда проекта легко собирается вместе; Команда имеет единое представление о це-\nлях и задачах; Информация внутри команды передается быстро и без искажений; Еди-\nная система ценностей и единство правил внутри команды; Единый лидер, признанный\n командой; Ответственность каждого члена команды определена.");
            controller.setAnswer(controller.getAnswer3(), "Команда проекта работает несогласованно; Команда имеет единое представление о це-\nлях и задачах; Каждый член команды имеет личную заинтересованность в достижении \nцелей; Информация внутри команды передается медленно, но без искажений; Единая\n система ценностей и единство правил внутри команды; Единый лидер, признанный ко-\nмандой; Ответственность каждого члена команды определена.");
            controller.setAnswer(controller.getAnswer4(), "Команда проекта легко собирается вместе; Команда имеет единое представление о це-\nлях и задачах; Каждый член команды имеет личную заинтересованность в достижении \nцелей; Информация внутри команды передается быстро и без искажений; Единая сис-\nтема ценностей и единство правил внутри команды; Единый лидер, признанный коман-\nдой; Ответственность каждого члена команды определена; Каждый член команды ра-\nботает по своему личному распорядку дня.");
        }
        {
            controller.setText(controller.getQuestion_2(), "О каком критерии идет речь в описании: “Этот критерий отражает энергетическую\nсогласованность командных действий, менеджер проекта может относиться к это-\nму критерию как к своего рода простому и быстрому тесту. Если кто-то из членов\nкоманды регулярно опаздывает, это знак того, что в будущем возможны пробле-\nмы с соблюдением сроков выполнения работ этим сотрудником. Менеджер про-\nекта должен постоянно помнить, что дисциплина крайне важна.”?");
            controller.setAnswer(controller.getAnswer1_2(), "Каждый член команды имеет личную заинтересованность в достижении целей");
            controller.setAnswer(controller.getAnswer2_2(), "Команда проекта легко собирается вместе");
            controller.setAnswer(controller.getAnswer3_2(), "Команда имеет единое представление о целях и задачах");
            controller.setAnswer(controller.getAnswer4_2(), "Информация внутри команды передается быстро и без искажений");
        }
        {
            controller.setText(controller.getQuestion_3(), "Важно ли для команды иметь единое представление о целях и задачах?");
            controller.setAnswer(controller.getAnswer1_3(), "Да");
            controller.setAnswer(controller.getAnswer2_3(), "Нет");
        }
        {
            controller.setText(controller.getQuestion_4(), "Выберите правильно определение термина «команда»:");
            controller.setAnswer(controller.getAnswer1_4(), "Команда — это двигатель проекта. Ее участники выполняют все необходимые\nзадачи в соответствии со своими желаниями, без ограничений во времени и\nресурсов");
            controller.setAnswer(controller.getAnswer2_4(), "Команда — коллектив единомышленников с высоким уровнем сплоченности,\nкомплиментарными навыками, приверженных общим намерениям, эффектив-\nным целям и единому подходу к работе, в рамках которого они считают себя\nвзаимоответственными");
            controller.setAnswer(controller.getAnswer3_4(), "Команда – трудовой коллектив с низким уровнем сплоченности, привержен-\nности всех работников общим целям и ценностям организации");
            controller.setAnswer(controller.getAnswer4_4(), "Команда – группа людей, имеющих различные цели, взаимодополняющие на-\nвыки и умения, низкий уровень взаимозависимости и разделяющих ответствен-\nность за достижение конечных результатов");
        }
        {
            controller.setText(controller.getQuestion_5(), "Управление командой проекта включает в себя:");
            controller.setAnswer(controller.getAnswer1_5(), "Формирование и развитие команды; Организация деятельности команды; Уп-\nравление персоналом команды; Распределение финансовых потоков");
            controller.setAnswer(controller.getAnswer2_5(), "Формирование и развитие команды; Управление персоналом команды");
            controller.setAnswer(controller.getAnswer3_5(), "Формирование и развитие команды; Организация деятельности команды; Уп-\nравление персоналом команды");
            controller.setAnswer(controller.getAnswer4_5(), "Формирование и развитие навыков и умений команды; Организация деятель-\nности команды; Управление персональными данными команды");
        }
        {
            controller.setText(controller.getQuestion_6(), "Какие типы управления командой существуют:");
            controller.setAnswer(controller.getAnswer1_6(), "Коллективистский, рыночный, бюрократический, демократический, диалоговый");
            controller.setAnswer(controller.getAnswer2_6(), "Коллективный, рыночный, бюрократический, демократичный, диалоговый");
            controller.setAnswer(controller.getAnswer3_6(), "Коллективный, рыночный, бюрократический, демократичный");
            controller.setAnswer(controller.getAnswer4_6(), "Коллективистский, рыночный, демократический, разговорный");
        }
        {
            controller.setText(controller.getQuestion_7(), "Выберите неверное определение термина «конфликт»:");
            controller.setAnswer(controller.getAnswer1_7(), "Антагонистическое взаимодействие сторон или отсутствие согласия между сто-\nронами");
            controller.setAnswer(controller.getAnswer2_7(), "Процесс взаимодействия между сторонами, в котором одна из сторон воспри-\nнимает другую, как ту, что негативно влияет (или пытается влиять) на то, что ва-\nжно для первой стороны");
            controller.setAnswer(controller.getAnswer3_7(), "Согласие между двумя или более сторонами");
            controller.setAnswer(controller.getAnswer4_7(), "Столкновение противоположно направленных целей, интересов, позиций, мне-\nний или взглядов двух или более людей; это борьба за определенный статус,\nвласть, ресурсы, целями которой являются нейтрализация, нанесение ущерба\nили уничтожение соперника");
        }
        {
            controller.setText(controller.getQuestion_8(), "Как нельзя действовать при возникновении конфликта:");
            controller.setAnswer(controller.getAnswer1_8(), "Напоминать об ошибках и промахах оппонента");
            controller.setAnswer(controller.getAnswer2_8(), "Идти на компромисс");
            controller.setAnswer(controller.getAnswer3_8(), "Идти на сотрудничество");
            controller.setAnswer(controller.getAnswer4_8(), "Уклоняться от конфликта");
        }
        {
            controller.setText(controller.getQuestion_9(), "Можно ли предупредить конфликт с помощью увольнения одного из конфликтующих?");
            controller.setAnswer(controller.getAnswer1_9(), "Да");
            controller.setAnswer(controller.getAnswer2_9(), "Нет");
        }
        {
            controller.setText(controller.getQuestion_10(), "Какого вида мотивации членов команды не существует?");
            controller.setAnswer(controller.getAnswer1_10(), "Мотивация вознаграждением");
            controller.setAnswer(controller.getAnswer2_10(), "Повышение статуса");
            controller.setAnswer(controller.getAnswer3_10(), "Мотивация угрозами");
            controller.setAnswer(controller.getAnswer4_10(), "Гарантия занятости");
        }
        {
            controller.setText(controller.getQuestion_11(), "Выберите верное определение термина «мотивация»:");
            controller.setAnswer(controller.getAnswer1_11(), "Процесс, по стимулированию человека или группы людей к автивизации деяте-\nльности по достижению целей организации");
            controller.setAnswer(controller.getAnswer2_11(), "Динамический психоэмоциональный процесс, который управляет поведением\nчеловека и определяет его рассеянность, неустойчивость и пассивность");
            controller.setAnswer(controller.getAnswer3_11(), "Процесс, с помощью которого генератор идей побуждает других членов\nкоманды работать для достижения личных целей");
            controller.setAnswer(controller.getAnswer4_11(), "Побуждение к действию, обусловливающее субъективно-личностное безразличие\nиндивида к совершению действия или достижению цели");
        }
        {
            controller.setText(controller.getQuestion_12(), "Является ли благоприятный климат в команде мотивационным фактором?");
            controller.setAnswer(controller.getAnswer1_12(), "Да");
            controller.setAnswer(controller.getAnswer2_12(), "Нет");
        }
        {
            controller.setText(controller.getQuestion_13(), "Классификации социальных взаимодействий, по какому признаку не существует?");
            controller.setAnswer(controller.getAnswer1_13(), "По продолжительности");
            controller.setAnswer(controller.getAnswer2_13(), "По бессознательности");
            controller.setAnswer(controller.getAnswer3_13(), "По количеству субъектов взаимодействия");
            controller.setAnswer(controller.getAnswer4_13(), "По “материи” обмена");
        }
        {
            controller.setText(controller.getQuestion_14(), "Верно ли утверждение: “Существует лишь два основных типа социальных\nвзаимодействий: сотрудничество и соперничество”?");
            controller.setAnswer(controller.getAnswer1_14(), "Да");
            controller.setAnswer(controller.getAnswer2_14(), "Нет");
        }
        {
            controller.setText(controller.getQuestion_15(), "Какой формы социального взаимодействия не существует?");
            controller.setAnswer(controller.getAnswer1_15(), "Объект-объективное");
            controller.setAnswer(controller.getAnswer2_15(), "Субъект-объективное");
            controller.setAnswer(controller.getAnswer3_15(), "Объект-субъективное");
            controller.setAnswer(controller.getAnswer4_15(), "Субъект-субъективное");
        }
        EndOfTest(controller, stage);
    }

    public void EndOfTest(HelloController controller, Stage stage) {
        controller.getButton_End().setOnAction(event -> {
            final Stage dialogStage = new Stage();
            dialogStage.setTitle("Завершение теста");
            dialogStage.setAlwaysOnTop(true);
            Label exitLabel = new Label("Вы действительно хотите завершить тестирование?\n\t\tВаши ответы будут сохранены.");
            dialogStage.setResizable(false);
            dialogStage.initStyle(StageStyle.UTILITY);

            Button yesBtn = new Button("Да");
            yesBtn.setOnAction(arg0 -> {
                dialogStage.close();
                stage.close();
                float score = controller.getPoints();
                float proponent = (score / 15) * 100;
                String formatted = String.format("%.2f", proponent);
                System.out.println("Прваильных ответов: " + score + "\nПроцент выполнения: " + formatted + "%");

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

        });

    }

    public void ColorChange(ToggleGroup group) {
        group.selectedToggleProperty().addListener((changed, oldValue, newValue) -> {
            RadioButton selected = (RadioButton) newValue;
            selected.setStyle("-fx-background-color: #0071ae;");
            RadioButton old = (RadioButton) oldValue;
            if (old != null) {
                old.setStyle("-fx-background-color: #C4C4C4;");
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}