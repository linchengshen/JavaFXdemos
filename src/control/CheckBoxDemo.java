package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *         ������ѡ��
 * 
 *         ���ǿ���ʹ��CheckBox�еĹ��캯��������CheckBox�Ķ���
 * 
 *         ������������ĸ�ѡ�����´�����ʾ -
 * 
 *         CheckBox checkBox = new CheckBox(); Java Ҫ���������ַ�������ĸ�ѡ�����´�����ʾ -
 * 
 *         CheckBox checkBox = new CheckBox("Second"); Java
 *         ������ѡ������ǿ��Ը������ı�������ѡ�С�
 * 
 *         checkBox.setText("First"); checkBox.setSelected(true);
 * 
 * 
 *
 *         ��ѡ��״̬
 * 
 *         ����ʹ��CheckBox����ʾ����״̬��
 * 
 *         Yes No Not Applicable(������) �������á�״̬�ǵ��ò�ȷ���� �����ѡ���ڲ�ȷ���У�����ѡ���ѡ��
 *         ѡ���ʾ�ǣ�δѡ���ʾ��
 * 
 *         ���ǿ���ͨ������CheckBox�����allowIndeterminate������ѡ��֧��Indeterminate��
 * 
 *         �������Ϊtrue����ѡ��Ӧ��ѭ��ѡ����������״̬��ѡ�У�ȡ��ѡ���δ���塣
 * 
 *         �������Ϊfalse����ѡ��ѭ��ѡ���ȡ��ѡ���״̬��
 */
public class CheckBoxDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage stage) {
		stage.setTitle("checkbox demo");

		CheckBox apple = new CheckBox();
		apple.setText("Apple");
		apple.setUserData("apple");

		// ѡ�л�ȡ���������¼�����
		apple.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if (newValue.booleanValue() == true) {
					System.out.println("you hava chose:" + apple.getUserData());
				}
			}

		});

		CheckBox banana = new CheckBox("Banana");
		banana.setUserData("banana");
		banana.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if (newValue.booleanValue() == true) {
					System.out.println("you hava chose:" + banana.getUserData());
				}
			}

		});

		CheckBox orange = new CheckBox("Orange");
		orange.setUserData("orange");
		orange.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				// TODO Auto-generated method stub
				if (newValue.booleanValue() == true) {
					System.out.println("you hava chose:" + orange.getUserData());
				}
			}
		});

		VBox root = new VBox(10);
		root.setPadding(new Insets(8, 0, 0, 8));
		HBox hbox = new HBox(8);
		hbox.setPadding(new Insets(8));

		hbox.getChildren().addAll(apple, banana, orange);

		Button button = new Button("submit");

		Label msg = new Label();
		msg.setFont(Font.font("arial", 18));
		msg.setTextFill(Color.web("#1a6ea1"));

		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				List<String> favirateFruit = new ArrayList<String>();

				Iterator<Node> checkList = hbox.getChildren().iterator();
				while (checkList.hasNext()) {
					CheckBox item = (CheckBox) checkList.next();
					// �ж��Ƿ�ѡ��
					if (item.isSelected()) {
						favirateFruit.add(item.getUserData().toString());
					}
				}
				String text = favirateFruit.size() == 0 ? "None favirate fruit"
						: "your favirate fruit is " + favirateFruit.toString();
				msg.setText(text);
			}
		});

		Label tip = new Label("Please select your favirate fruit:");
		tip.setTextFill(Color.web("#1a6ea1"));
		tip.setFont(Font.font("arial", FontWeight.NORMAL, 26));
		root.getChildren().addAll(tip, hbox, button, msg);

		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.show();
	}

}
