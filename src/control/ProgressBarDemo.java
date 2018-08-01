package control;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 * 
 *         ProgressBar ��ʾ������ public ProgressBar()
 * 
 *         ��ָ��������ֵ�Ĺ����� public ProgressBar(double value)
 * 
 *         ����ͨ��setProgress(double value)���ý�������ֵ
 *
 */
public class ProgressBarDemo extends Application {

	// instance variables
	private DoubleProperty dp = new SimpleDoubleProperty(0.25);

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("progressbar demo");

		ProgressBar pb = new ProgressBar();
		pb.setProgress(0.25);
		pb.setPadding(new Insets(8));
		pb.setScaleX(1.2);
		pb.setScaleY(1.2);
		pb.progressProperty().bind(dp);

		Button btn = new Button("press");
		btn.setAlignment(Pos.BASELINE_LEFT);
		btn.setPadding(new Insets(8));
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				double currentValue = dp.get();
				double step = 0.1;
				final double epsilon = 0.000001;

				// ����ǰ�ж��Ƿ񳬹�1�������򲻸���
				// �жϸ�������ֵ��ȣ����ھ������⣬����ֱ����==
				if (1.0 - currentValue >= epsilon) {
					dp.setValue(currentValue + step);
				}
				System.out.println(dp.get());
			}
		});

		VBox root = new VBox(10);
		root.getChildren().addAll(pb, btn);
		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
