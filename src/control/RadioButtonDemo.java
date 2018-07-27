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
 *         单选按钮文本默认出现在右边 单选按钮通常组合在一起，以便用户进行单选，即用户只能在单选按钮列表中选择一个项目。
 *         例如，当选择鞋子尺寸时，我们通常从列表中选择一个尺寸。
 * 
 *         单选按钮只能执行：选择或取消选择。
 * 
 *         以下代码显示，当放置在ToggleGroup中时，只能选择一个RadioButton。
 * 
 *         应该用ToggleGroup来包装RadioButton
 * 
 *         调用RadioButton的setToggleGroup(ToggleGroup obj)
 * 
 *         单选按钮组
 * 
 *         单选按钮通常在组中使用。 我们可以添加单选按钮到ToggleGroup对象，它将管理它们，使得一次只能选择一个单选按钮。
 *         
 *
 */
public class RadioButtonDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("单选按钮示例");

		ToggleGroup tg = new ToggleGroup();

		// 创建单选按钮
		RadioButton male = new RadioButton("male");

		// 默认选中，要和requestFocus()配合使用
		male.setSelected(true);
		male.requestFocus();

		male.setUserData("选中男人");

		RadioButton female = new RadioButton();
		female.setText("female");
		female.setUserData("选中女人");

		male.setToggleGroup(tg);
		female.setToggleGroup(tg);

		// RadioButton的行为
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