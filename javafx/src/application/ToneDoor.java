package application;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class ToneDoor {
	
	public ToneDoor(){
		
		String ssound = "sound.mp3";
	    Media sound = new Media(ssound);
	    MediaPlayer mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
		
	}

}
