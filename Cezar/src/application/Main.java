package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root =FXMLLoader.load(getClass().getResource("MainApp.fxml"));
			primaryStage.setTitle("Шифратор");
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Lock.png")));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
