package application;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Main extends Application {

	static Scene scene1;//Scene 1 is Menu, Scene 2 is the game
	Scene scene2;
	private static ArrayList<Integer> roomUsed =new ArrayList<Integer>();
	private static ArrayList<Integer> tonePressed = new ArrayList<Integer>();


	@Override
	public void start(Stage primaryStage) {
		try {
			/************************** Setting up Basics **************************/

			//setting up the stage, scene and root
			BorderPane root = new BorderPane();//for scene 1
			BorderPane root2 = new BorderPane();//creating the root layouts for the scenes
			root.setId("pane");//setting an ID to a root (for CSS)

			scene1 = new Scene(root,500,500);//creating scene1
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1
			scene2 = new Scene(root2,800,600);//creating scene1
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1
			primaryStage.setTitle("Doors.exe");//setting the title of the window

			/************************** Setting Up Variables**************************/

			String name = "";

			/***** Scene 1 *****/

			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(500);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(500);

			//title
			HBox titleBox = new HBox();//creating the Scene Title
			titleBox.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",0.25), new CornerRadii(0), new Insets(0,0,0,0))));//setting the background of the box
			Text sceneTitle = new Text("This is our Scene Title ");
			sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));//creating text and adding font, weight and size
			titleBox.getChildren().addAll(sceneTitle);//adding the text to the HBox
			titleBox.setAlignment(Pos.TOP_CENTER);
			titleBox.setPadding(new Insets(25,25,25,25));


			//buttons
			Button play = new Button("PLAY");//creating Play Button
			play.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",1), new CornerRadii(25), new Insets(0,0,0,0))));//background of button
			//play.hoverProperty();//TODO look at this!
			play.setMinWidth(300);//setting values
			play.setMinHeight(50);
			play.setOnMouseEntered(e -> play.setBackground(new Background(new BackgroundFill(Color.web("0xAFDEDB",1), new CornerRadii(30), new Insets(0,0,0,0)))));//background of button);
			play.setOnMouseExited(e -> play.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",1), new CornerRadii(25), new Insets(0,0,0,0)))));//background of button);
			play.setOnMousePressed(e -> play.setMinSize(250, 42));
			play.setOnMouseReleased(e -> play.setMinSize(300,50));
			play.setOnAction(e -> getRoom(primaryStage,scene1));

			VBox vbox = new VBox();//creating a VBox for the buttons
			vbox.setAlignment(Pos.CENTER);//alignment
			vbox.setPadding(new Insets(35,35,35,35));//padding of box
			vbox.setSpacing(30);//spacing of elements
			vbox.getChildren().addAll(play);//adding buttons to the box


			root.setTop(titleBox);//compiling the root
			root.setCenter(vbox);

			/***** Scene 2 *****/

			/*			Button back = new Button("PAUSE");//creating a new button
			back.setMinWidth(50);//setting values
			back.setMinHeight(50);
			back.setBackground(new Background(new BackgroundFill(Color.web("0xFFFF00"), new CornerRadii(0), new Insets(10,10,10,10))));
			back.setOnAction(e -> scene1(primaryStage));*/

			//top menu
			GridPane displayMenu = new GridPane();									//color				//roundness			//padding
			displayMenu.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5"), new CornerRadii(0), new Insets(10,10,10,10))));//setting the background of the box
			displayMenu.setPadding(new Insets(15,25,15,25));//set padding of box

			// Category in column 2, row 0
			Text category = new Text(""+name+"Jimmy");
			category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			displayMenu.add(category, 1, 0);

			/*			File file = new File("bin/application/content/pause2.png");
			Image image = new Image(file.toURI().toString());
			ImageView imageView = new ImageView();
			imageView.setImage(image);
			// Pause icon in column 6, row 0
			displayMenu.add(imageView, 5 , 0);*/

			Button button = new Button("Button");
			button.setOnAction(e -> getRoom(primaryStage, scene1));

			root2.setTop(displayMenu);
			root2.setCenter(button);
			/************************** Compiling Program **************************/

			primaryStage.setScene(scene1);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public  void scene1(Stage primaryStage){//onClick of the BACK button

		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);//sets the dimensions of the stage
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(500);

		primaryStage.setScene(scene1);

	}

	public void setScene(Stage primaryStage, Scene scene){

		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(800);//sets the dimensions of the stage
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(800);
		System.out.println("setScene");
		primaryStage.setScene(scene);//goes to scene two
	}

	public void scene2(Stage primaryStage){//onClick of the PLAY button

		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(800);//sets the dimensions of the stage
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(800);

		primaryStage.setScene(scene2);//goes to scene two
	}

	static int counter = 0;

	public Scene getRoom(Stage primaryStage, Scene scene1){
		counter++;
		//randomNumber (not yet called) (no duplicates)
		Scene randRoom = null;
		int roomChoice = (int) ((3*Math.random())+1);

		System.out.println(roomChoice);
		boolean gameOver=false;
		while(true){
			if(counter>3){//if the game has run out of rooms
				System.out.println("Game Over Function");
				gameOver=true;
				scene1 = gameOver(primaryStage);
				break;
			}
			else if(roomUsed.size()>0 && roomUsed.contains(roomChoice)){
				roomChoice = (int) ((3*Math.random())+1);
				System.out.println("else if : "+roomChoice);
			}else{
				System.out.println("else");
				break;
			}
		}



		System.out.println("Before if//else");

		if(gameOver){
			randRoom=scene1;
		}
		else if(roomChoice == 1){

			randRoom = listen(primaryStage, scene1);
			System.out.println("Room 1");
			roomUsed.add(roomChoice);

		}else if(roomChoice == 2){

			randRoom = room2(primaryStage, scene1);
			System.out.println("Room 2");
			roomUsed.add(roomChoice);

		}else if(roomChoice == 3){

			randRoom = room3(primaryStage, scene1);
			System.out.println("Room 3");
			roomUsed.add(roomChoice);

		}

		//based on the random number a room is returned from this method
		System.out.println("Got here");
		setScene(primaryStage, randRoom);

		return randRoom;

	}

	private Scene listen(Stage primaryStage, Scene scene1){

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 500, 500);

		root.setId("room");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1

		ToneDoor.toneGen();
		
		VBox vbox = new VBox();
		Text text = new Text("Listen Closely");
		text.setFont(Font.font("Arial", FontWeight.BOLD, 35));

		Button button = new Button("Play Sound");
		button.setBackground(new Background(new BackgroundFill(Color.web("0xAD55ED",0.75), new CornerRadii(0), new Insets(0,0,0,0))));//setting the background of the box
		button.setPadding(new Insets(15,15,15,15));
		button.setOnAction(e -> room1(primaryStage, scene1, 0));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(text, button);

		root.setCenter(vbox);

		return scene;

	}

	private Scene room1(Stage primaryStage, Scene scene1, int roomState){

		Scene room1;

		BorderPane root = new BorderPane();//for scene 1
		room1 = new Scene(root,500,500);//creating scene1
		root.setId("room");
		room1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1


		HBox titleBox = new HBox();//creating the Scene Title
		titleBox.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",0.25), new CornerRadii(0), new Insets(0,0,0,0))));//setting the background of the box
		Text sceneTitle = new Text("TONES");
		sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 30));//creating text and adding font, weight and size
		titleBox.getChildren().addAll(sceneTitle);//adding the text to the HBox
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(25,25,25,25));

		Button A = new Button("A");//creating a new button
		A.setOnAction(e -> {
			ToneDoor.playTone(0);
			tonePressed.add(1); //Combined the setOnAction commands
			interTone(primaryStage);
		});
		A.setMinWidth(200);//setting values
		A.setMinHeight(200);

		if(roomState == 1){

			A.setBackground(new Background(new BackgroundFill(Color.web("0x00FF90"), new CornerRadii(0), new Insets(10,10,10,10))));

		}else{

			A.setBackground(new Background(new BackgroundFill(Color.web("0x00FF00"), new CornerRadii(0), new Insets(10,10,10,10))));

		}

		Button D = new Button("D");//creating a new button
		D.setOnAction(e -> {
			ToneDoor.playTone(2);
			tonePressed.add(3); //Combined the setOnAction commands
			interTone(primaryStage);
		});
		D.setMinWidth(200);//setting values
		D.setMinHeight(200);

		if(roomState == 2){

			D.setBackground(new Background(new BackgroundFill(Color.web("0xFF9000"), new CornerRadii(0), new Insets(10,10,10,10))));

		}else{

			D.setBackground(new Background(new BackgroundFill(Color.web("0xFF0000"), new CornerRadii(0), new Insets(10,10,10,10))));

		}

		Button G = new Button("G");//creating a new button
		G.setOnAction(e -> {
			ToneDoor.playTone(1);
			tonePressed.add(2);	//Combined the setOnAction commands
			interTone(primaryStage);
		});
		G.setMinWidth(200);//setting values
		G.setMinHeight(200);

		if(roomState == 3){

			A.setBackground(new Background(new BackgroundFill(Color.web("0x0009FF"), new CornerRadii(0), new Insets(10,10,10,10))));

		}else{

			A.setBackground(new Background(new BackgroundFill(Color.web("0x0000FF"), new CornerRadii(0), new Insets(10,10,10,10))));

		}

		if(roomState == 0){

			int[] order = ToneDoor.toneGen();

			for(int a = 0; a < 3; a++){

				if(order[a] == 1){

					setScene(primaryStage, room1(primaryStage, scene1, 1));

					ToneDoor.playTone(0);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else if(order[a] == 2){


					setScene(primaryStage, room1(primaryStage, scene1, 2));

					ToneDoor.playTone(1);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}else if(order[a] == 3){

					setScene(primaryStage, room1(primaryStage, scene1, 3));

					ToneDoor.playTone(2);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}



			}

		}

		root.setTop(titleBox);
		root.setCenter(A);
		root.setLeft(G);
		root.setRight(D);

		return room1;

		//compiles the scene that the room will be
	}

	private Scene room2(Stage primaryStage, Scene scene1){

		Scene room2;

		//compiles the scene that the room will be

		BorderPane root = new BorderPane();//for scene 1
		room2 = new Scene(root,500,500);//creating scene1
		room2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1

		root.setId("room");


		GridPane gp = new GridPane();//Creating a GridPane to use for the buttons

		Button button;
		int width = (int) (Math.random()*9);//two random integers for the REAL button location
		int height = (int) (Math.random()*7);

		System.out.println("W: "+width+" \\ H: "+height);

		for(int i=0; i<9; i++){//setting the horizontal index of the buttons
			for(int j=0; j<7; j++){//setting the vertical index of the buttons
				button = new Button("Click ME");//creates a new button
				if(i == width && j == height){//if the for statements are at the positions that the REAL button should be placed at
					System.out.println("Into IF");
					button.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
					button.setOnAction(e -> toWaitingRoom(primaryStage, scene1));//sets the action to going to the waiting room
				}
				button.setMaxHeight(80);
				button.setMinHeight(80);	//sets the height and width
				button.setMinWidth(87);
				button.setMaxWidth(87);
				gp.add(button, i, j);//adds the button to the GridPane
			}
		}

		root.setCenter(gp);//sets the GridPane to the root

		return room2;

	}

	private Scene room3(Stage primaryStage, Scene scene1){

		Scene room3;
		String[] words = new String[]{
				"cacophony","dichotomy","epitome","euphemism","gregarious","idiosyncratic","infinitesimal","narcissist","ostentatious","perfunctory","quintessential"
		};
		//compiles the scene that the room will be

		BorderPane root = new BorderPane();//for scene 1
		room3 = new Scene(root,500,500);//creating scene1
		room3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1
		root.setId("room");

		HBox titleBox = new HBox();//the box holding the title and the random word
		Text text = new Text("Input the word: ");//title
		Text word = new Text();//text for the random word
		text.setFont(Font.font("Arial", FontWeight.BOLD, 30));//setting font
		word.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		String selection;//var to keep the selection word
		word.setText(selection = words[(int) (Math.random()*words.length)]);//selecting the word and setting the variable
		titleBox.getChildren().addAll(text,word);//adding elements to the box
		titleBox.setAlignment(Pos.CENTER);//setting it all to center alignement

		HBox hbox = new HBox();
		TextField textField = new TextField();//new textfield
		Button submit = new Button("Submit");//new button
		submit.setOnAction(e -> {//setting the button to set check the spelling of the input (matching in up to the selected word)
			toVariable(textField.getText());
			if(textField.getText().equals(selection))toWaitingRoom(primaryStage, scene1);
		});
		hbox.getChildren().addAll(textField,submit);//adding the field and button elements to a box
		hbox.setAlignment(Pos.CENTER);//setting the alignment

		root.setTop(titleBox);//title and word
		root.setCenter(hbox);//field and box

		return room3;//returning the completed word

	}

	static String input;

	public void toVariable(String string){//takes the input and assigns it to the static input variable
		input = string;
	}

	public void toWaitingRoom(Stage primaryStage, Scene scene){//goes to the waiting room (between rooms)

		Scene waitingRoom;
		primaryStage.setTitle("WAITING ROOM...");
		BorderPane root = new BorderPane();//for scene 1
		waitingRoom = new Scene(root,500,500);//creating scene1
		root.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, new CornerRadii(0), null)));

		root.setId("room");
		waitingRoom.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1

		HBox titleBox = new HBox();//creating the Scene Title
		titleBox.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",0.25), new CornerRadii(0), new Insets(0,0,0,0))));//setting the background of the box
		titleBox.setPadding(new Insets(15,15,15,15));
		Text label = new Text("Good Job!");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		titleBox.getChildren().addAll(label);//adding the text to the HBox
		titleBox.setAlignment(Pos.TOP_CENTER);

		Button goButton = new Button("Next Challenge");
		goButton.setBackground(new Background(new BackgroundFill(Color.web("0xAD55ED",0.75), new CornerRadii(25), new Insets(0,0,0,0))));//background of button
		goButton.setMinWidth(300);//setting values
		goButton.setMinHeight(50);

		goButton.setOnAction(e -> {
			primaryStage.setTitle("Doors.exe");
			getRoom(primaryStage, scene);//goes to main menu
		});
		root.setTop(titleBox);//setting the stuff
		root.setCenter(goButton);

		primaryStage.setScene(waitingRoom);

	}

	public Scene gameOver(Stage primaryStage){//after the game is complete

		counter = 0; //resetting the game (can be played again w/out re-launching)
		roomUsed.clear();//clearing the used rooms variable
		tonePressed.clear();
		
		Scene scene;
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);//sets the dimensions of the stage
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(500);
		primaryStage.setTitle("GAME OVER");

		BorderPane root = new BorderPane();//for scene 1
		scene = new Scene(root,500,500);//creating scene1

		root.setId("room");
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());//getting the style sheet for scene1

		HBox titleBox = new HBox();//creating the Scene Title
		titleBox.setBackground(new Background(new BackgroundFill(Color.web("0x8BD9D5",0.25), new CornerRadii(0), new Insets(0,0,0,0))));//setting the background of the box
		titleBox.setPadding(new Insets(15,15,15,15));
		Text label = new Text("Thanks for Playing!");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		titleBox.getChildren().addAll(label);//adding the text to the HBox
		titleBox.setAlignment(Pos.TOP_CENTER);

		VBox vbox = new VBox();

		Text credits= new Text("Credits\n\n");
		Text programmers = new Text("Programmers:\n");
		Text one = new Text("Benjamin MacKay\n");
		Text two = new Text("Mark Frezell\n\n");
		Text images = new Text("FreePix.com & WallpaperSafari.com\n\n");
		credits.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		programmers.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
		one.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
		two.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
		images.setFont(Font.font("Arial", FontWeight.NORMAL, 18));


		Button goButton = new Button("Main Menu");
		goButton.setBackground(new Background(new BackgroundFill(Color.web("0xAD55ED",0.75), new CornerRadii(25), new Insets(0,0,0,0))));//background of button
		goButton.setMinWidth(300);//setting values
		goButton.setMinHeight(50);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(credits, programmers, one, two, images, goButton);//setting all the elements to the vbox

		goButton.setOnAction(e -> {
			primaryStage.setTitle("Doors.exe");
			mainMenu(primaryStage);
		});
		root.setTop(titleBox);
		root.setCenter(vbox);

		return scene;
		//		primaryStage.setScene(scene);

		//TODO create game over scene and set the scene

	}

	public void mainMenu(Stage primaryStage){//onClick of the BACK button

		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);//sets the dimensions of the stage
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(500);

		primaryStage.setScene(scene1);

	}

	public void interTone(Stage primaryStage){

		if(tonePressed.size() >= 3){

			if(ToneDoor.toneCheck(tonePressed.get(0), tonePressed.get(1), tonePressed.get(2))){

				toWaitingRoom(primaryStage, scene1);

			}else{


				Alert alert = new Alert(AlertType.CONFIRMATION, "Please Try Again!");
				alert.show();
				tonePressed.clear();

			}

		}

	}

}
