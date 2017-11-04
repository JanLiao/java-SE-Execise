import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
 
/**
 * 
 * @ClassName: Mp3Player
 * @Description: TODO(播放.mp3 音乐文件)
 * @author fyf
 * @date 2015年7月10日 下午3:02:09
 */
public class Mp3Player {
 
    /**
     * 
     * @Title: getMp3Time
     * @Description: TODO(获取mp3文件的播放时间)
     * @author fyf
     * @return time(00:00)
     */
    public String getMp3Time(String mp3FilePath) {
 
        try {
            File file = new File(mp3FilePath);
 
            if (file.exists() && file.isFile()) {
                FileInputStream fis = new FileInputStream(file);
                int bytes = fis.available();
 
                Bitstream bit = new Bitstream(fis);
                Header header = bit.readFrame();
                long time = (long) header.total_ms(bytes);
                System.out.println(time);
 
                return formatTime(time);
            }
        } catch (IOException | BitstreamException e) {
            System.out.println(e);
        }
 
        return null;
    }
 
    /**
     * 
     * @Title: formatTime
     * @Description: TODO(格式化时间：mm:ss；分：秒)
     * @author fyf
     * @return time(00:00)
     */
    public String formatTime(long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
 
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
 
        return dateFormat.format(calendar.getTime());
    }
 
    /**
     * 
     * @Title: playerMp3
     * @Description: TODO(播放mp3)
     * @author fyf
     * @param mp3File
     *            mp3文件路径
     */
    public void playerMp3(String mp3FilePath) {
        BufferedInputStream buffer = null;
 
        /**
         * 获取文件数据流
         */
        try {
            buffer = new BufferedInputStream(new FileInputStream(mp3FilePath));
        } catch (Exception e) {
            try {
                buffer = new BufferedInputStream(new URL(mp3FilePath).openStream());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
 
        try {
            Player player = new Player(buffer);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
 
    }
 
    public static void main(String[] args) {
        Mp3Player mp3Player = new Mp3Player();
        String mp3FilePath = "D:\\KuGou\\陈百强 - 盼三年.mp3";

         // MP3File file = new MP3File(mp3FilePath);            
         //     MP3AudioHeader audioHeader = (MP3AudioHeader)file.getAudioHeader();
             
         //     String strLen = audioHeader.getTrackLengthAsString();
         //    System.out.println(strLen);
 
        String mp3Time = mp3Player.getMp3Time(mp3FilePath);
        System.out.println(mp3Time);
        mp3Player.playerMp3(mp3FilePath);
 
        // 播放网络文件
        // mp3FilePath = "http://music.baidutt.com/up/kwcawscw/yyaumy.mp3";
        // mp3Player.playerMp3(mp3FilePath);
    }
}