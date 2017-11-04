
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.south.client.util.Constant;
import org.south.client.util.PropertyUtil;
import org.south.netty.msg.FileDto;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class PlayerApplication extends Application {  //播放器

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		  Group root = new Group();
	      Scene scene = new Scene(root, Constant.ledLength, Constant.ledWidth);
	      
	      primaryStage.setX(Constant.startSpotLeft);
	      primaryStage.setY(Constant.startSpotTop);
	      primaryStage.setScene(scene);
	      primaryStage.sizeToScene();
	      primaryStage.initStyle(StageStyle.UNDECORATED);//设定窗口无边框
	      primaryStage.show();
	      
	      setPlayVedioList(scene);
	      
	      primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              System.out.println("Stage is closing");
	              System.exit(0);
	          }
	      }); 
	      
	      
	}
	
	public void setPlayVedioList(Scene scene) {  //设置播放视频列表
		//先判断有无视频可以播放
    	if(Constant.getVedioFiles().size() < 1) {
    		//JOptionPane.showMessageDialog(null, "没有需要播放的视频", "提示", JOptionPane.ERROR_MESSAGE); 
    		return;
    	}
    	
    	final List<MediaPlayer> players = new ArrayList<>();
    	for(FileDto fileDto: Constant.getVedioFiles()) {
    		players.add(createPlayer(fileDto));
    	}
    	
    	final MediaView mediaView = new MediaView(players.get(0));
        // play each vedio file in turn.
        for (int i = 0; i < players.size(); i++) {
          final MediaPlayer player = players.get(i);
          final MediaPlayer nextPlayer = players.get((i + 1) % players.size());
          player.setOnEndOfMedia(new Runnable() {
            @Override public void run() {
              player.stop();
              mediaView.setMediaPlayer(nextPlayer);
              System.out.println("nextPlayer:" + nextPlayer);
              nextPlayer.play();
            }
          });
        }
        
        
       // start playing the first track.
       mediaView.setMediaPlayer(players.get(0));
       ((Group) scene.getRoot()).getChildren().add(mediaView);
       mediaView.getMediaPlayer().play();
	}
		
	
	 
	 private MediaPlayer createPlayer(FileDto fileDto) {
		String vedioFilePath = PropertyUtil.DownloadDirectoryPath + "/" + fileDto.getFileName();
	    final Media media = new Media(new File(vedioFilePath).toURI().toString());
	    final MediaPlayer player = new MediaPlayer(media);
	    player.setOnError(new Runnable() {
	      @Override public void run() {
	        System.out.println("Media error occurred: " + player.getError());
	      }
	    });
	    return player;
	 }
}
