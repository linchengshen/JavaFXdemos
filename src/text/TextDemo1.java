package text;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 文本的基本使用
 * 
 * @author Administrator
 *
 */
public class TextDemo1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("文本示例1");

		Group root = new Group();

		// 定义文本
		Text sampleText = new Text(50, 100, "JavaFx 2.0");
		sampleText.setRotate(60);
		sampleText.setFill(Color.rgb(248, 147, 24, .80));
		sampleText.setFont(Font.font("arial", FontWeight.NORMAL, 25));
		root.getChildren().add(sampleText);

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
