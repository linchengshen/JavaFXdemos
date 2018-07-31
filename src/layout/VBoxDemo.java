package layout;

import java.util.Iterator;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *         VBox类似与HBox,一个是水平排列，一个是垂直排列
 */
public class VBoxDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		primaryStage.setTitle("VBox布局demo");

		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));

		Label label = new Label("VBox");
		label.setFont(Font.font("arial", FontWeight.BOLD, 32));

		Button btn1 = new Button("button 1");
		Button btn2 = new Button("button 2");
		Button btn3 = new Button("button 3");
		Button btn4 = new Button("button 4");
		Button btn5 = new Button("button 5");

		vbox.getChildren().addAll(label, btn1, btn2, btn3, btn4, btn5);

		/**
		 * 迭代每个Button子节点，加上点击事件处理方法
		 */
		ObservableList<Node> childrens = vbox.getChildren();
		Iterator<Node> it = childrens.iterator();
		while (it.hasNext()) {
			Node node = it.next();
			if (node.getClass() == Button.class) {
				Button btn = (Button) node;
				btn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						System.out.println(btn.getText() + " clicked");
					}
				});
			}
		}
		Scene scene = new Scene(vbox, 650, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
