package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Board {
	/*
	 * Board runs and handles all the behind the scenes**
	 *
	 * This class contains methods that main can use throughout the program to:
	 * 	generate doors
	 * 	handle stuff
	 * 	etc.
	 */

	 private static ArrayList<Integer> roomUsed =new ArrayList<Integer>();

	public static Scene getRoom(Stage primaryStage, Scene scene1){

		//randomNumber (not yet called) (no duplicates)
		Scene randRoom = null;
		int roomChoice = 0;

		while(true){
			if(roomUsed.size()>0){
			if(roomUsed.contains(roomChoice)){

				roomChoice = (int) Math.random() * 3;
				roomChoice=0;
			}else{
				System.out.println("else");
				break;
			}
			}
		}

		if(roomChoice == 0){

			randRoom = room1(primaryStage, scene1);
			roomUsed.add(roomChoice);

		}else if(roomChoice == 1){

			randRoom = room2();
			roomUsed.add(roomChoice);

		}else if(roomChoice == 2){

			randRoom = room3();
			roomUsed.add(roomChoice);

		}

		//based on the random number a room is returned from this method

		return randRoom;

	}


	private static Scene room1(Stage primaryStage, Scene scene1){

		Scene room1;

		BorderPane root = new BorderPane();//for scene 1
		room1 = new Scene(root,500,500);//creating scene1

		HBox titleBox = new HBox();//creating the Scene Title
		titleBox.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",0.25), new CornerRadii(0), new Insets(0,0,0,0))));//setting the background of the box
		Text sceneTitle = new Text("Room 1");
		sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));//creating text and adding font, weight and size
		titleBox.getChildren().addAll(sceneTitle);//adding the text to the HBox
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(25,25,25,25));

		Button back = new Button("PAUSE");//creating a new button
		back.setOnAction(e -> scene1(primaryStage, scene1));
		back.setMinWidth(50);//setting values
		back.setMinHeight(50);
		back.setBackground(new Background(new BackgroundFill(Color.web("0xFFFF00"), new CornerRadii(0), new Insets(10,10,10,10))));


		//compiles the scene that the room will be


		return null;
	}


	private static Scene room2(){

		Scene room2;

		//compiles the scene that the room will be


		return null;
	}

	private static Scene room3(){

		Scene room3;

		//compiles the scene that the room will be


		return null;
	}

	public static void scene1(Stage primaryStage, Scene scene1){//onClick of the BACK button

		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);//sets the dimensions of the stage
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(500);

		primaryStage.setScene(scene1);

	}


}
