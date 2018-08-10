package control;

import java.util.Optional;

import javafx.application.Application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *	
 */

public class AlertDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		test2();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	// test1
	public void test1() {
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you want to format your system?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			System.out.println("format system");
		}
	}

	public void test2() {
		Alert alert = new Alert(AlertType.ERROR, "System will exit in 30 seconds!");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			System.out.println("click ok");
		}
	}

}
