package control;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 * 
 *         TextField 用于单行文本输入 有两个构造器 public
 *         TextField(),创建空白的文本框对象，调用setText()方法设置文本 public TextField(String
 *         text),创建带指定文本的文本框对象
 */
public class TextFieldDemo extends Application {

	// instance variable
	StringProperty title = new SimpleStringProperty();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// 使用grid布局
		primaryStage.setTitle("TextField demo");
		GridPane root = new GridPane();
		root.setPadding(new Insets(8));
		root.setHgap(8);
		root.setVgap(8);

		Label toUser = new Label("toUser:");

		TextField sample = new TextField();
		sample.setPromptText("Enter your first name");

		sample.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}

		});
		sample.copy();
		root.add(toUser, 0, 0);
		root.add(sample, 1, 0);

		title.bind(sample.textProperty());
		primaryStage.titleProperty().bind(title);

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
