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
 *         切换按钮具有两种状态：选择或未选择。 通常将两个或多个切换按钮组合成一个组，并允许用户只选择一个按钮或不选择。
 * 
 *         创建切换按钮
 * 
 *         ToggleButton类的三个构造函数创建一个切换按钮。要创建没有任何字幕或图标的切换按钮。
 * 
 *         ToggleButton tb = new ToggleButton(); Java 要创建带有文字说明的切换按钮
 * 
 *         ToggleButton tb = new ToggleButton(String text); Java
 *         要创建带有文字说明和图标的切换按钮。
 * 
 *         Image image = new Image(getClass().getResourceAsStream("icon.png"));
 *         ToggleButton tb = new ToggleButton ("Press me", new
 *         ImageView(image)); Java
 *         setText()方法可以将文本设置为ToggleButton，以及setGraphic()方法可以将图像安装到ToggleButton。
 * 
 *         切换按钮组
 * 
 *         切换组不强制选择至少一个按钮。单击所选的切换按钮可取消选择切换按钮。
 * 
 * 
 *         ToggleButton行为
 * 
 *         setUserData()方法将用户值与切换按钮相关联。ChangeListener对象检查组中选定的切换。如果没有选择任何开关按钮，则输出默认值。
 * 
 *         如果选择其中一个切换按钮，getSelectedToggle和getUserData方法返回用户定义的值。
 */
public class ToggleButtonDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("切换按钮demo");

		// 创建切换按钮组对象，用来包装ToggleButton

		ToggleGroup toggle = new ToggleGroup();

		// 创建切换按钮
		ToggleButton t1 = new ToggleButton();
		t1.setText("High");
		t1.setUserData("you chose High");
		// 默认选择
		// t1.setSelected(true);
		// t1.requestFocus();
		t1.setToggleGroup(toggle);

		ToggleButton t2 = new ToggleButton("Medium");
		t2.setUserData("you chose Medium");
		t2.setToggleGroup(toggle);

		ToggleButton t3 = new ToggleButton("Low");
		t3.setUserData("you chose Low");
		t3.setToggleGroup(toggle);

		// 事件处理
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
		
		//加载样式表
		scene.getStylesheets().add(this.getClass().getResource("btnStyle.css").toExternalForm());
		
		//设置样式
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
