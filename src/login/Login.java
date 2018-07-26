package login;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends javafx.application.Application {

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("JavaFX Welcome");
		
		//把grid添加到场景
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25,25,25,25));
		Scene scene = new Scene(grid,600,400);
		
		
		//把其他元素添加到grid
		Text sceneTitle = new Text("Welcome");
		sceneTitle.setId("welcome-text");
		sceneTitle.setFont(Font.font("arial", FontWeight.NORMAL, 20));
		grid.add(sceneTitle, 0, 0, 2, 1);
		
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		
		Label password = new Label();
		password.setText("Password:");
		grid.add(password, 0, 2);
		
		PasswordField pwField = new PasswordField();
		grid.add(pwField, 1, 2);
		
		
		Button btn = new Button();
		btn.setId("btn");
		btn.setText("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn,1,4);
		
		final Text actionTarget = new Text();
		actionTarget.setId("actiontarget");
		grid.add(actionTarget, 1, 6);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				actionTarget.setFill(Color.FIREBRICK);
				if("linchengshen".equals(userTextField.getText()) && "wojia666@zaozao".equals(pwField.getText())) {
					actionTarget.setText("Success logined!");
				}else {
					actionTarget.setText("username or password error!");
				}
			}
		});
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Login.class.getResource("login.css").toExternalForm());
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
