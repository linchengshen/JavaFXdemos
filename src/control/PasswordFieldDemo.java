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
 *         PasswordField�����������롣�û�������ַ�ͨ����ʾ�����ַ��������ء�
 * 
 *         ���������ֶ�
 * 
 *         ���´���ʹ������PasswordField���Ĭ�Ϲ��캯������һ�������ֶΣ�Ȼ��Ϊ�����ֶ�������ʾ��Ϣ�ı���
 *         ��ʾ��Ϣ���ֶ�����ʾΪ��ɫ�ı�����Ϊ�û��ṩ���ֶ���ʲô����ʾ������ʹ�ñ�ǩ�ؼ���
 * 
 *         PasswordField passwordField = new PasswordField();
 *         passwordField.setPromptText("Your password"); Java
 *         PasswordField����setText������Ϊ�ؼ������ı��ַ��������������ֶΣ�ָ�����ַ����ɻ����ַ����ء�
 *         Ĭ������£������ַ���һ����(�����Ǻ�)��
 * 
 *         �����ֶ��е�ֵ����ͨ��getText()������ȡ��
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

		Label passworldLabel = new Label("���������룺");
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
