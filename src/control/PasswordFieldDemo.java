package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 *         PasswordField用于密码输入。用户键入的字符通过显示回显字符串被隐藏。
 * 
 *         创建密码字段
 * 
 *         以下代码使用来自PasswordField类的默认构造函数创建一个密码字段，然后为密码字段设置提示消息文本。
 *         提示消息在字段中显示为灰色文本，并为用户提供该字段是什么的提示，而不使用标签控件。
 * 
 *         PasswordField passwordField = new PasswordField();
 *         passwordField.setPromptText("Your password"); Java
 *         PasswordField类有setText方法来为控件设置文本字符串。对于密码字段，指定的字符串由回显字符隐藏。
 *         默认情况下，回显字符是一个点(或是星号)。
 * 
 *         密码字段中的值可以通过getText()方法获取。
 *
 */
public class PasswordFieldDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("PasswordField demo");
		VBox root = new VBox(8);
		root.setPadding(new Insets(8));
		root.setAlignment(Pos.BASELINE_LEFT);
		
		HBox hbox = new HBox(8);
		hbox.setAlignment(Pos.BASELINE_LEFT);

		Label passworldLabel = new Label("请输入密码：");
		PasswordField password = new PasswordField();
		password.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				
			}

		});

		Label msg = new Label();
		msg.textProperty().bind(password.textProperty());
		
		hbox.getChildren().addAll(passworldLabel, password);
		root.getChildren().addAll(hbox,msg);

		Scene scene = new Scene(root, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
