package application;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

	Scene scene1, scene2;//Scene 1 is Menu, Scene 2 is the game

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
			play.setOnAction(e -> scene2(primaryStage));

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

	        File file = new File("bin/application/content/pause.png");
	        Image image = new Image(file.toURI().toString());
	        ImageView imageView = new ImageView();
	        imageView.setImage(image);
		    // Pause icon in column 6, row 0
		    displayMenu.add(imageView, 5 , 0);


			root2.setTop(displayMenu);

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

	public void scene1(Stage primaryStage){//onClick of the BACK button

		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);//sets the dimensions of the stage
		primaryStage.setMaxHeight(500);
		primaryStage.setMaxWidth(500);

		primaryStage.setScene(scene1);

	}

	public void scene2(Stage primaryStage){//onClick of the PLAY button

		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(800);//sets the dimensions of the stage
		primaryStage.setMaxHeight(600);
		primaryStage.setMaxWidth(800);

		primaryStage.setScene(scene2);//goes to scene two
	}
}
