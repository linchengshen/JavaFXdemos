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
 *         FlowPane布局 FlowPane是一个容器。它在一行上排列连续的子组件，并且如果当前行填满了以后，则自动将子组件向下推到下一行。
 *         或者窗体大小发生变化的时候会自动重排
 */
public class FlowPaneDemo extends Application {

	public void start(Stage primaryStage) {

		// 设置窗体标题
		primaryStage.setTitle("FlowPane布局示例");

		// 设置root节点
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

		// 鼠标点击button的响应事件

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
