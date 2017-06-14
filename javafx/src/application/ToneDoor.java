package application;

import javafx.scene.media.AudioClip;

public class ToneDoor {

	public ToneDoor(){


	}

	public static void playTone(int toneNumber){

		AudioClip tone1 = new AudioClip(ToneDoor.class.getResource("A.mp3").toExternalForm());
		AudioClip tone2 = new AudioClip(ToneDoor.class.getResource("G.mp3").toExternalForm());
		AudioClip tone3 = new AudioClip(ToneDoor.class.getResource("D.mp3").toExternalForm());

		if(toneNumber == 0){
			
			try {
				
				tone1.play();
				Thread.sleep(1000);
				tone1.stop();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}else if(toneNumber == 1){

			try {
				
				tone2.play();
				Thread.sleep(1000);
				tone2.stop();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else if(toneNumber == 2){

			try {
				
				tone3.play();
				Thread.sleep(1000);
				tone3.stop();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public static int[] toneGen(){

		int[] toneOrder = new int[3];
		
		toneOrder[0] = (int) ((Math.random() * 3) + 1);
		toneOrder[1] = (int) ((Math.random() * 3) + 1);
		toneOrder[2] = (int) ((Math.random() * 3) + 1);
		
		return toneOrder;

	}

}
