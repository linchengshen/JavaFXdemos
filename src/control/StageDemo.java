package control;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 * 
 *         Stage �̳���Window��Window����һ������������PopupWindow Popup�̳���PopupWindow
 *
 */

public class StageDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// ���ñ���
		primaryStage.setTitle("primary stage title");
		Group root = new Group();
		Label label = new Label("Hello World!");
		label.textFillProperty().set(Color.web("#000"));
		label.setFont(Font.font("arial", FontWeight.NORMAL, 32));
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		// �¼�������
		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ESCAPE) {
					Platform.exit();
				}
			}
		});
		// �������Ӧ����
		primaryStage.sizeToScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
