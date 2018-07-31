package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HBoxDemo2 extends Application {

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("HBox演示2");
		Group root = new Group();

		// 创建带默认子节点距离的hbox对象,5px;
		HBox hbox = new HBox(5);

		// hbox 的内边距为1px
		hbox.setPadding(new Insets(1));

		// 创建hbox的四个子节点
		Rectangle r1 = new Rectangle(10, 20, Color.rgb(255, 0, 0));
		Rectangle r2 = new Rectangle(20, 100);
		Rectangle r3 = new Rectangle(50, 20);
		Rectangle r4 = new Rectangle(20, 50);

		//设置子节点r1的外边距，其余子节点不受影响
		HBox.setMargin(r1, new Insets(10));
		hbox.getChildren().addAll(r1, r2, r3, r4);

		root.getChildren().add(hbox);

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
