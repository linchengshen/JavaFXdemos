package property;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UIBindingDemo extends Application {
	private final static String MY_PASS = "passwd";// ��ʼ����
	private final static BooleanProperty accessGranted = new SimpleBooleanProperty(false);

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub

		User user = new User();
		stage.setTitle("ui���԰�demo");

		Group root = new Group();

		//����ı��ֶ�

		Text userName = new Text();
		userName.setX(50);
		userName.setY(50);
		userName.textProperty().bind(user.userNameProperty());

		//password �ֶ�
		PasswordField password = new PasswordField();
		password.setLayoutX(50);
		password.setLayoutY(70);
		password.setPromptText("Password");
		user.passwordProperty().bind(password.textProperty());

		password.setOnAction(new EventHandler<ActionEvent>() {

			//��Ӧĳ���¼�
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if (accessGranted.get()) {
					System.out.println("granted access:" + user.getUserName());
					System.out.println("password:" + user.getPassword());
					System.out.println(password.textProperty().get());
					Platform.exit();
				} else {
					stage.setTitle("no access");
				}
			}

		});

		//������ֵ�����仯ʱ����ĳ�ֲ���
		password.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				System.out.println("changed");
				boolean granted = password.getText().equals(MY_PASS);
				accessGranted.set(granted);
				if (granted) {
					stage.setTitle("");
				}
			}
		});

		root.getChildren().addAll(userName,password);
		Scene scene = new Scene(root, 800, 450);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
