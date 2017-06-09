package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			GridPane gp1 = new GridPane();

			primaryStage.setTitle("Doors.exe");

			

/*			Text title = new Text();
			title.setText("Our DOOR Game");
			Text textLeft = new Text();
			title.setText("Left");
			Text textRight = new Text();
			title.setText("Right");*/

			Text scenetitle = new Text("This is our title");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

			//creating buttons
			Button play = new Button("PLAY");
			play.setMinWidth(300);
			play.setMinHeight(50);
			Button options = new Button("OPTIONS");

			HBox hbox = new HBox();
			hbox.getChildren().addAll(scenetitle);
			hbox.setAlignment(Pos.TOP_CENTER);

			VBox vbox = new VBox();
			vbox.setStyle("-fx-background: #FFFFFF;");
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(35,35,35,35));
			vbox.setSpacing(10);
			vbox.getChildren().addAll(play,options);

			root.setTop(hbox);
			root.setCenter(vbox);

			primaryStage.setMinHeight(500);
			primaryStage.setMinWidth(500);
			primaryStage.setMaxHeight(500);
			primaryStage.setMaxWidth(500);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
