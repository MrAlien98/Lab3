package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.BVC_APP;


public class Main extends Application {
	
	public static BVC_APP bvc;
	
	public Main() {
		bvc=new BVC_APP();
	}
	
	public static BVC_APP getBVC() {
		return bvc;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			primaryStage.getIcons().add(new Image("img/BVC.png"));
			primaryStage.setTitle("BOLSA DE VALORES DE COLOMBIA");
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
