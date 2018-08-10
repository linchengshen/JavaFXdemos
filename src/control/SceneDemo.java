package control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SceneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("scene demo");
		Group root = new Group();
		Scene scene = new Scene(root, 600, 450);
		// scene.fillProperty().set(Color.BLACK);
		scene.setFill(Color.AQUAMARINE);

		Circle circle = new Circle(300, 225, 100);
		circle.setFill(Color.web("#1245aa"));
		root.getChildren().add(circle);

		// 事件处理函数
		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				System.out.println("key " + event.getCode().getName() + " was pressed");
			}

		});
		// 事件处理函数
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//System.out.println(event.getButton().name());// PRIMARY,SECOND,MIDDLE
				if(event.getButton()==MouseButton.PRIMARY) {
					circle.setScaleX(1.5);
					circle.setScaleY(1.5);
					circle.setFill(Color.AZURE);
				}else if(event.getButton() == MouseButton.SECONDARY) {
					circle.setScaleX(1);
					circle.setScaleY(1);
					circle.setFill(Color.web("#1245aa"));
				}
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
