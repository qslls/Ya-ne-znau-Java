package example.app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 664, 549);
        stage.setTitle("SambrerUS");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();
        controller.getAnswer1().setText("Это, конечно, классно, но ты проверял, как оно будет работать с большим текстом?\n Ммм?  Не слышу. Конечно же нет, ты просто решил с помощью одного слова написать\n и проверить саму функцию, её дальнейший функционал тебя мало волновал");

    }


    public static void main(String[] args)
    {
        launch();
    }
}