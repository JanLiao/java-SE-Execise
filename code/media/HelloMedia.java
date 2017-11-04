 import javafx.application.Application;
 import javafx.stage.Stage;
 import javafx.stage.*;
 import javafx.geometry.Pos;
 import javafx.scene.Scene;
 import javafx.scene.control.Button;
 import javafx.scene.control.Label;
 import javafx.scene.control.Slider;
 import javafx.scene.layout.BorderPane;
 import javafx.scene.layout.HBox;
 import javafx.scene.layout.Region;
 import javafx.scene.layout.*;
 import javafx.scene.media.Media;
 import javafx.scene.media.MediaPlayer;
 import javafx.scene.media.MediaView;
 import javafx.util.Duration;
 import java.io.*;

public class HelloMedia extends Application{
	public void start(Stage stage) throws Exception{
		Button button = new Button("Hello  World!!!");
		StackPane myPane = new StackPane();
		myPane.getChildren().add(button);
		Scene scene = new Scene(myPane);
		stage.setScene(scene);
		stage.setWidth(900);
		stage.setHeight(600);
//		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}