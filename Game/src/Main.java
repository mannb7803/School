import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Created by Ben on 5/14/2018.
 */
public class Main extends Application{
    @Override
    public void start(Stage mainStage)throws Exception
    {
        GridPane gridMain = new GridPane();
        gridMain.setPadding(new Insets(20, 20, 20, 20));
        gridMain.setMinSize(1080, 720);
        gridMain.setVgap(5);
        gridMain.setHgap(5);


        Button buttonStartGame = new Button("Start");
        Button buttonContinueGame = new Button("Continue");
        Button buttonOption = new Button("Options");
        mainMenuActionListeners(true);

        gridMain.add(buttonStartGame, 0, 0);
        gridMain.add(buttonContinueGame, 0, 2);
        gridMain.add(buttonOption, 0, 4);

            mainStage.setTitle("v1");
            Scene mainMenuScene = new Scene(gridMain, 1080, 720);
            mainStage.setScene(mainMenuScene);
            mainStage.show();

    }
    public static void mainMenuActionListeners(boolean x, Button b1, Button b2, Button b3)
    {
        b1.getOnMouseClicked()
    }
    public static void main (String [] input)
    {
        launch(input);
    }
}
