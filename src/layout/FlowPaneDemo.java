package layout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         FlowPane���� FlowPane��һ������������һ������������������������������ǰ���������Ժ����Զ�������������Ƶ���һ�С�
 *         ���ߴ����С�����仯��ʱ����Զ�����
 */
public class FlowPaneDemo extends Application {

	public void start(Stage primaryStage) {

		// ���ô������
		primaryStage.setTitle("FlowPane����ʾ��");

		// ����root�ڵ�
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(15, 15, 15, 15));
		root.setHgap(10);
		root.setVgap(20);

		// button 1

		Button btn1 = new Button();
		btn1.setText("Button1");
		root.getChildren().add(btn1);

		// button 2
		Button btn2 = new Button("Button2");
		btn2.setPrefSize(100, 100);
		root.getChildren().add(btn2);

		// TextField
		TextField sampleTextField = new TextField("Text Field");
		sampleTextField.setPrefWidth(180);
		root.getChildren().add(sampleTextField);

		// checkBox
		CheckBox checkBox = new CheckBox("Check Box");
		root.getChildren().add(checkBox);

		// Radio

		RadioButton radio = new RadioButton("radio button");
		root.getChildren().add(radio);

		// �����button����Ӧ�¼�

		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String formatedDateString = sdf.format(Calendar.getInstance().getTime());
				sampleTextField.setText(formatedDateString);
			}

		});

		Scene scene = new Scene(root, 450, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
