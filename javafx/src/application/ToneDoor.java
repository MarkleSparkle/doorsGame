package application;

import javafx.scene.media.Media;
import java.io.File;
import javafx.scene.media.AudioClip;



public class ToneDoor {

	public ToneDoor(){


	}

	public static void playTone(int toneNumber){

		AudioClip tone1 = new AudioClip("");
		AudioClip tone2 = new AudioClip("");
		AudioClip tone3 = new AudioClip("");

		if(toneNumber == 0){

			tone1.play();

		}else if(toneNumber == 1){

			tone2.play();

		}else if(toneNumber == 2){

			tone3.play();

		}

	}

	public static void toneGen(){



	}

}
