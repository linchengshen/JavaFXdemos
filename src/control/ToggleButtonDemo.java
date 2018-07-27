package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *
 *         �л���ť��������״̬��ѡ���δѡ�� ͨ�������������л���ť��ϳ�һ���飬�������û�ֻѡ��һ����ť��ѡ��
 * 
 *         �����л���ť
 * 
 *         ToggleButton����������캯������һ���л���ť��Ҫ����û���κ���Ļ��ͼ����л���ť��
 * 
 *         ToggleButton tb = new ToggleButton(); Java Ҫ������������˵�����л���ť
 * 
 *         ToggleButton tb = new ToggleButton(String text); Java
 *         Ҫ������������˵����ͼ����л���ť��
 * 
 *         Image image = new Image(getClass().getResourceAsStream("icon.png"));
 *         ToggleButton tb = new ToggleButton ("Press me", new
 *         ImageView(image)); Java
 *         setText()�������Խ��ı�����ΪToggleButton���Լ�setGraphic()�������Խ�ͼ��װ��ToggleButton��
 * 
 *         �л���ť��
 * 
 *         �л��鲻ǿ��ѡ������һ����ť��������ѡ���л���ť��ȡ��ѡ���л���ť��
 * 
 * 
 *         ToggleButton��Ϊ
 * 
 *         setUserData()�������û�ֵ���л���ť�������ChangeListener����������ѡ�����л������û��ѡ���κο��ذ�ť�������Ĭ��ֵ��
 * 
 *         ���ѡ������һ���л���ť��getSelectedToggle��getUserData���������û������ֵ��
 */
public class ToggleButtonDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("�л���ťdemo");

		// �����л���ť�����������װToggleButton

		ToggleGroup toggle = new ToggleGroup();

		// �����л���ť
		ToggleButton t1 = new ToggleButton();
		t1.setText("High");
		t1.setUserData("you chose High");
		// Ĭ��ѡ��
		// t1.setSelected(true);
		// t1.requestFocus();
		t1.setToggleGroup(toggle);

		ToggleButton t2 = new ToggleButton("Medium");
		t2.setUserData("you chose Medium");
		t2.setToggleGroup(toggle);

		ToggleButton t3 = new ToggleButton("Low");
		t3.setUserData("you chose Low");
		t3.setToggleGroup(toggle);

		// �¼�����
		toggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				// TODO Auto-generated method stub
				String toPrint = newValue == null ? "default value" : newValue.getUserData().toString();
				System.out.println(toPrint);
			}

		});

		HBox hbox = new HBox(4);
		hbox.setPadding(new Insets(10));

		hbox.getChildren().addAll(t1, t2, t3);
		

		Scene scene = new Scene(hbox, 600, 400);
		
		//������ʽ��
		scene.getStylesheets().add(this.getClass().getResource("btnStyle.css").toExternalForm());
		
		//������ʽ
		t1.getStyleClass().add("toggle-button1");
		t2.getStyleClass().add("toggle-button2");
		t3.getStyleClass().add("toggle-button3");
		
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
