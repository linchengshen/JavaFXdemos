package color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WEBColorDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("HSB��ɫʾ��");

		Text sampleText = new Text();
		sampleText.setText("javafx ʾ������");
		sampleText.setFont(Font.font("arial", 35));
		
		/**
		 * hsb����ͬ����������͸��ֵ
		 */
		sampleText.setFill(Color.web("#000", 0.8));
		sampleText.setX(200);
		sampleText.setY(100);
		//˳ʱ����ת
		sampleText.setRotate(15);

		Group root = new Group();
		root.getChildren().add(sampleText);

		Scene scene = new Scene(root, 800, 450);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
