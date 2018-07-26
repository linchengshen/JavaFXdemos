package text;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 */
public class TextDemo2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		// ����stagee����
		primaryStage.setTitle("�ı�ʾ��2");
		// ���ó���
		Scene scene = new Scene(new Group(), 600, 450);

		// ���һ��Բ
		Group group = (Group) scene.getRoot();
		group.getChildren().add(new Circle(100, 50, 40));
		// �����ı�
		Text sampleText = new Text();
		// �������λ��
		sampleText.setX(50);
		sampleText.setY(50);
		sampleText.setText("JavaFx 2.0");

		// ������ʽ

		sampleText.setFill(Color.RED);
		sampleText.setFont(Font.font("arial", FontWeight.NORMAL, 35));
		((Group) scene.getRoot()).getChildren().add(sampleText);

		// ������Ӱ
		DropShadow effect = new DropShadow(5, 3, 3, Color.BLACK);
		sampleText.setEffect(effect);

		Reflection r = new Reflection();
		r.setFraction(0.8);
		sampleText.setEffect(r);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
