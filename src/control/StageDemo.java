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
 *         Stage 继承自Window。Window还有一个抽象子类是PopupWindow Popup继承字PopupWindow
 *
 */

public class StageDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 设置标题
		primaryStage.setTitle("primary stage title");
		Group root = new Group();
		Label label = new Label("Hello World!");
		label.textFillProperty().set(Color.web("#000"));
		label.setFont(Font.font("arial", FontWeight.NORMAL, 32));
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		// 事件处理函数
		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ESCAPE) {
					Platform.exit();
				}
			}
		});
		// 宽高自适应场景
		primaryStage.sizeToScene();
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
