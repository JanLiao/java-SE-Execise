import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class JavaFXTest extends Application{
	public void start(Stage primaryStage){
		Button button=new Button("pass");
		Scene scene=new Scene(button,200,300);
		primaryStage.setTitle("JavaFXTest");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args){
		Application.launch(args);
	}
}