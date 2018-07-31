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
 *         GridPane通常用于布局：第一列上的只读标签的输入表单和第二列上的输入字段。
 *         GridPane可以在行，列或单元格级别指定约束。
 *          例如，我们可以设置包含输入文本字段的第二列，以在窗口调整大小时调整大小。
 *          
 *          以下代码演示使用GridPane布局的简单表单应用程序。它有以下布局。

			+------------------------+
			| [label ] [   field   ] |
			| [label ] [   field   ] |
			|             [ button ] |
			+------------------------+
			GridPane只有一个缺省无参数的构造器
 */
public class GridPaneDemo extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("GridPane布局demo");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15));
		
		//设置子节点水平，垂直放心的gap，间距
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
					infoMsg.setText("请输入用户名");
					return;
				}
				if("".equals(password)) {
					infoMsg.setText("请输入密码");
					return;
				}
				infoMsg.setText(username+","+password+"  保存成功");
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
