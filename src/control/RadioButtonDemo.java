package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         ��ѡ��ť�ı�Ĭ�ϳ������ұ� ��ѡ��ťͨ�������һ���Ա��û����е�ѡ�����û�ֻ���ڵ�ѡ��ť�б���ѡ��һ����Ŀ��
 *         ���磬��ѡ��Ь�ӳߴ�ʱ������ͨ�����б���ѡ��һ���ߴ硣
 * 
 *         ��ѡ��ťֻ��ִ�У�ѡ���ȡ��ѡ��
 * 
 *         ���´�����ʾ����������ToggleGroup��ʱ��ֻ��ѡ��һ��RadioButton��
 * 
 *         Ӧ����ToggleGroup����װRadioButton
 * 
 *         ����RadioButton��setToggleGroup(ToggleGroup obj)
 * 
 *         ��ѡ��ť��
 * 
 *         ��ѡ��ťͨ��������ʹ�á� ���ǿ�����ӵ�ѡ��ť��ToggleGroup���������������ǣ�ʹ��һ��ֻ��ѡ��һ����ѡ��ť��
 *         
 *
 */
public class RadioButtonDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("��ѡ��ťʾ��");

		ToggleGroup tg = new ToggleGroup();

		// ������ѡ��ť
		RadioButton male = new RadioButton("male");

		// Ĭ��ѡ�У�Ҫ��requestFocus()���ʹ��
		male.setSelected(true);
		male.requestFocus();

		male.setUserData("ѡ������");

		RadioButton female = new RadioButton();
		female.setText("female");
		female.setUserData("ѡ��Ů��");

		male.setToggleGroup(tg);
		female.setToggleGroup(tg);

		// RadioButton����Ϊ
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// TODO Auto-generated method stub
				System.out.println(tg.getSelectedToggle().getUserData().toString());
			}

		});

		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(8));

		vbox.getChildren().addAll(male, female);
		Scene scene = new Scene(vbox, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}