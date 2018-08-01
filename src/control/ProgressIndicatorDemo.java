package control;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 * 
 *         进度指示器(ProgressIndicator)以动态更改饼图的形式显示JavaFX中的操作进度。
 *
 */
public class ProgressIndicatorDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("进度条指示器demo");
		VBox root = new VBox(10);
		root.setPadding(new Insets(8));


		ProgressIndicator pi = new ProgressIndicator();
		

		// 指定参数的进度指示条
		ProgressIndicator pi2 = new ProgressIndicator(0.65);

		root.getChildren().addAll(pi, pi2);
		Scene scene = new Scene(root, 450, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
