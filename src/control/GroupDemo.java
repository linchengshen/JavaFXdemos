package control;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Administrator
 *
 *
 *         public Group extends Parent A Group node contains an ObservableList
 *         of children that are rendered in order whenever this node is
 *         rendered. A Group will take on the collective bounds of its children
 *         and is not directly resizable.
 * 
 */
public class GroupDemo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setTitle("Group example");
		Group root = new Group();

		for (int i = 0; i < 5; i++) {
			Rectangle r = new Rectangle();
			r.setY(i * 20);
			r.setWidth(100);
			r.setHeight(20);
			r.setFill(Color.RED);
			root.getChildren().add(r);
		}
		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
