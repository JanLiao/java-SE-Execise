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
 import javafx.scene.layout.*;
 import javafx.scene.layout.Region;
 import javafx.scene.media.Media;
 import javafx.scene.media.MediaPlayer;
 import javafx.scene.media.MediaView;
 import javafx.util.Duration;
 import java.io.*;
 import javafx.event.EventHandler;
 import java.util.*;
 import java.text.*;

 public class MediaTest extends Application{
 	private static final String PATH = "C:/Users/MrLiao/Desktop/code/media/1024 (1).mp4";

 	public void start(Stage stage) throws Exception{
 		// File f = new File(PATH);
 		// Media media = new Media(f.toURI().toString());
 		// MediaPlayer mediaPlayer = new MediaPlayer(media);
 		// MediaView mediaView = new MediaView(mediaPlayer);
 		// mediaPlayer.play();
 		// HBox hBox = new HBox(10);
 		// hBox.setAlignment(Pos.CENTER);
 		BorderPane pane = new BorderPane();
// 		pane.setCenter(mediaView);
// 		pane.getChildren().add(mediaView);
// 		pane.setBottom(hBox);
 		Scene scene = new Scene(pane);

 		setPlayerList(scene);


 		stage.setX(0);
 		stage.setY(0);
 		stage.setScene(scene);
 		stage.setWidth(1000);
 		stage.setHeight(650);
//		stage.initStyle(StageStyle.TRANSPARENT);
 		stage.initStyle(StageStyle.UNDECORATED);
 		stage.show();
 		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
 			public void handle(WindowEvent we) {
 				System.out.println("Stage is closing");
 				System.exit(0);
 			}
 		});
 	}

 	public void setPlayerList(Scene scene){
 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 		
 		final List<MediaPlayer> list = new ArrayList<MediaPlayer>();
 		list.add(playMedia());
    list.add(playMedia1());
    list.add(playMedia2());
    list.add(playMedia3());
    list.add(playMedia4());
    final MediaView view = new MediaView(list.get(0));
    for(int i = 0; i < list.size(); i++){
      System.out.print("i= " + i);
      MediaPlayer player = list.get(i);
      MediaPlayer nextPlayer = list.get((i + 1) % list.size());
      System.out.print(player);
      System.out.print("   ");
      System.out.println(nextPlayer);
      player.setOnEndOfMedia(new Runnable() {
        public void run() {
          player.stop();
          view.setMediaPlayer(nextPlayer);
          Slider slVolume = new Slider();
          slVolume.setPrefWidth(150);
          slVolume.setMaxWidth(Region.USE_PREF_SIZE);
          slVolume.setMinWidth(30);
          slVolume.setValue(0);
          view.getMediaPlayer().volumeProperty().bind(
            slVolume.valueProperty().divide(100));
          System.out.print(df.format(new Date()));
          System.out.print("   ");
          System.out.println("nextPlayer:" + nextPlayer);
          nextPlayer.play();
        }
      });
    }

    System.out.println("==========");

    view.setMediaPlayer(list.get(0));
    ((BorderPane)scene.getRoot()).getChildren().add(view);
    Slider slVolume = new Slider();
    slVolume.setPrefWidth(150);
    slVolume.setMaxWidth(Region.USE_PREF_SIZE);
    slVolume.setMinWidth(30);
    slVolume.setValue(0);
    view.getMediaPlayer().volumeProperty().bind(
      slVolume.valueProperty().divide(100));
    view.getMediaPlayer().play();
  }

  public MediaPlayer playMedia(){
   File f1 = new File(PATH);
   Media media = new Media(f1.toURI().toString());
   return new MediaPlayer(media);
 }

 public MediaPlayer playMedia1(){
  File f1 = new File("C:/Users/MrLiao/Desktop/code/media/1024 (2).mp4");
  Media media = new Media(f1.toURI().toString());
  return new MediaPlayer(media);
}

public MediaPlayer playMedia2(){
 File f1 = new File("C:/Users/MrLiao/Desktop/code/media/1024 (3).mp4");
 Media media = new Media(f1.toURI().toString());
 return new MediaPlayer(media);
}
public MediaPlayer playMedia3(){
 File f1 = new File("C:/Users/MrLiao/Desktop/code/media/1024 (4).mp4");
 Media media = new Media(f1.toURI().toString());
 return new MediaPlayer(media);
}
public MediaPlayer playMedia4(){
 File f1 = new File("C:/Users/MrLiao/Desktop/code/media/1024 (5).mp4");
 Media media = new Media(f1.toURI().toString());
 return new MediaPlayer(media);
}

public static void main(String[] args){
 launch(args);
}
}