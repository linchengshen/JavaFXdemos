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
 *         ����ָʾ��(ProgressIndicator)�Զ�̬���ı�ͼ����ʽ��ʾJavaFX�еĲ������ȡ�
 *
 */
public class ProgressIndicatorDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("������ָʾ��demo");
		VBox root = new VBox(10);
		root.setPadding(new Insets(8));


		ProgressIndicator pi = new ProgressIndicator();
		

		// ָ�������Ľ���ָʾ��
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
