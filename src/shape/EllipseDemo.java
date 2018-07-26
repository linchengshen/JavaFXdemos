package shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class EllipseDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("��Բʾ��");

		Group root = new Group();
		Scene scene = new Scene(root, 500, 350);

		// ������Բ
		Ellipse ellipse = new Ellipse(100, 100, 100, 50);
		
		//������ӰЧ��
		
		DropShadow effect = new DropShadow();
		effect.setOffsetY(3);
		effect.setOffsetX(3);
		effect.setColor(Color.BLACK);
		
		//Ϊ��Բ���Ч��
		ellipse.setEffect(effect);
		ellipse.setFill(Color.BLACK);
		root.getChildren().add(ellipse);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
