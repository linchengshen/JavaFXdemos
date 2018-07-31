package layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator GridPane
 * 
 *         GridPaneͨ�����ڲ��֣���һ���ϵ�ֻ����ǩ��������͵ڶ����ϵ������ֶΡ�
 *         GridPane�������У��л�Ԫ�񼶱�ָ��Լ����
 *          ���磬���ǿ������ð��������ı��ֶεĵڶ��У����ڴ��ڵ�����Сʱ������С��
 *          
 *          ���´�����ʾʹ��GridPane���ֵļ򵥱�Ӧ�ó����������²��֡�

			+------------------------+
			| [label ] [   field   ] |
			| [label ] [   field   ] |
			|             [ button ] |
			+------------------------+
			GridPaneֻ��һ��ȱʡ�޲����Ĺ�����
 */
public class GridPaneDemo extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("GridPane����demo");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15));
		
		//�����ӽڵ�ˮƽ����ֱ���ĵ�gap�����
		grid.setVgap(8);
		grid.setHgap(8);
		
		Scene scene  = new Scene(grid,450,300);
		
		
		Label label = new Label("Welcome");
		label.setFont(Font.font("arial", FontWeight.MEDIUM, FontPosture.ITALIC,30));
		Label usernameLabel = new Label("username");
		Label passwordLabel = new Label("password");
		
		//TextField
		
		TextField usernameField = new TextField();
		PasswordField passwordField = new PasswordField();
		Label infoMsg = new Label();
		
		//button
		Button btn = new Button("save");
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				infoMsg.setTextFill(Color.rgb(255, 0, 0));
				if("".equals(username)) {
					infoMsg.setText("�������û���");
					return;
				}
				if("".equals(password)) {
					infoMsg.setText("����������");
					return;
				}
				infoMsg.setText(username+","+password+"  ����ɹ�");
			}
		});
		
		
		grid.add(label, 0, 0);
		grid.add(usernameLabel, 0, 1);
		grid.add(passwordLabel, 0, 2);
		grid.add(usernameField, 1, 1);
		grid.add(passwordField, 1, 2);
		grid.add(btn,1,3);
		grid.add(infoMsg, 1, 4);
			
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	

}
