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

		primaryStage.setTitle("HBox��ʾ2");
		Group root = new Group();

		// ������Ĭ���ӽڵ�����hbox����,5px;
		HBox hbox = new HBox(5);

		// hbox ���ڱ߾�Ϊ1px
		hbox.setPadding(new Insets(1));

		// ����hbox���ĸ��ӽڵ�
		Rectangle r1 = new Rectangle(10, 20, Color.rgb(255, 0, 0));
		Rectangle r2 = new Rectangle(20, 100);
		Rectangle r3 = new Rectangle(50, 20);
		Rectangle r4 = new Rectangle(20, 50);

		//�����ӽڵ�r1����߾࣬�����ӽڵ㲻��Ӱ��
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
