package color;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RGBColorDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("rgb ��ɫ������ʹ��ʾ��");
		Group root = new Group();
		Scene scene = new Scene(root, 1000, 600);

		// ����ı�
		Text sampleText = new Text(100, 100, "javafx rgb ����");

		Paint c = Color.rgb(124, 147, 255, 0.6);// ��alphaͨ����rgb����alpha������ɫ�Ĳ�͸����
		//Color c1 = Color.rgb(124, 147, 255);
		sampleText.setFont(Font.font("arial", 32));
		sampleText.setFill(c);
		root.getChildren().add(sampleText);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
