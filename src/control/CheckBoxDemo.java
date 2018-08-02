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
 *         创建复选框
 * 
 *         我们可以使用CheckBox中的构造函数来创建CheckBox的对象。
 * 
 *         创建不带标题的复选框，如下代码所示 -
 * 
 *         CheckBox checkBox = new CheckBox(); Java 要创建带有字符串标题的复选框，如下代码所示 -
 * 
 *         CheckBox checkBox = new CheckBox("Second"); Java
 *         创建复选框后，我们可以更改其文本并将其选中。
 * 
 *         checkBox.setText("First"); checkBox.setSelected(true);
 * 
 * 
 *
 *         复选框状态
 * 
 *         可以使用CheckBox来表示三个状态：
 * 
 *         Yes No Not Applicable(不适用) “不适用”状态是调用不确定。 如果复选框不在不确定中，可以选择或不选择。
 *         选择表示是，未选择表示否。
 * 
 *         我们可以通过设置CheckBox对象的allowIndeterminate属性来选择支持Indeterminate。
 * 
 *         如果设置为true，则复选框应该循环选择所有三个状态：选中，取消选择和未定义。
 * 
 *         如果设置为false，复选框将循环选择和取消选择的状态。
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

		// 选中或取消发生的事件处理
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
					// 判断是否被选择
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
