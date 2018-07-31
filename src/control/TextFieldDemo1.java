package control;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 *         覆盖replaceText和replaceSelection以创建自定义的TextField
 *
 *
 *         下面的代码生成以下结果，只能输入数字值 -
 */
public class TextFieldDemo1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("自定义的TextField");

		Label phoneLabel = new Label("手机号码：");

		// 设置子节点水平距离为8px
		HBox root = new HBox(10);
		root.setPadding(new Insets(8));
		// 设置子节点文本居中
		root.setAlignment(Pos.BASELINE_LEFT);
		// 匿名内部子类
		TextField myTextField = new TextField() {
			// 初始化代码块 打印匿名类的父类
			{
				System.out.println(this.getClass().getSuperclass());
			}

			@Override
			public void replaceText(final int start, final int end, final String text) {
				if (!text.matches("[a-zA-Z]")) {
					super.replaceText(start, end, text);
				}
			}

			@Override
			public void replaceSelection(String replacement) {
				if (!replacement.matches("[a-zA-Z]")) {
					super.replaceSelection(replacement);
				}
			}
		};

		myTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue.toString());
			}

		});

		root.getChildren().add(phoneLabel);
		root.getChildren().add(myTextField);

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
