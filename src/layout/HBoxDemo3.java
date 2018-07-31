package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxDemo3 extends Application {

	public void start(Stage stage) {

		stage.setTitle("HBox �������ͼ��");

		// ����ÿ���ӽڵ��ˮƽ���
		HBox hbox = new HBox(10);
		// ����hbox��padding,����15������13
		hbox.setPadding(new Insets(15, 12, 15, 12));

		// �����Ԫ��

		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		Button button3 = new Button("button3");
		Button button4 = new Button("button4");
		Button button5 = new Button("button5");

		hbox.getChildren().addAll(button1, button2, button3, button4, button5);
		stage.setScene(new Scene(hbox));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
