package control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         ��ɫѡ�����ؼ������û��ӿ��õ���ɫ��Χ��ѡ����ɫ����ͨ��ָ��RGB��HSB�������������ɫ��JavaFX
 *         ColorPicker�ؼ�������ɫѡ��������ɫ����Զ�����ɫ�Ի��򴰿ڡ�
 */
public class ColorPickerDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Color pickerDemo");
		GridPane root = new GridPane();

		ColorPicker cp = new ColorPicker(Color.BLACK);
		Label text = new Label("Hello World");
		text.setFont(Font.font("arial", FontWeight.NORMAL, 25));
		root.add(cp, 0, 0);
		root.add(text, 0, 1);

		cp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				text.setTextFill(cp.getValue());
				// 0x59514eff �����ʽ��r,g,b,o(͸����)
				System.out.println(cp.getValue().toString());
			}
		});

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
