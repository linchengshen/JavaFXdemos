package control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 * 
 *         Hyperlink���ʾ������JavaFX����ҳ�ϵ�ê���ӵĳ����ӡ�
 * 
 *         Hyperlink �̳���labeled�� ������������ public Hyperlink(); public
 *         Hyperlink(String text); public Hyperlink(String text,Node graphic)
 */
public class HpyerlinkDemo extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hyperlink demo");

		Group root = new Group();
		Hyperlink link = new Hyperlink();
		link.setPadding(new Insets(10, 0, 0, 40));
		link.setText("http://personalcarehub.info");

		// ������ʽ

		// ȡ��Ĭ�ϱ߿�
		link.setBorder(null);
		// �����ı���ɫ
		link.setTextFill(Color.web("#cba45c"));
		// ȡ���»���
		link.setUnderline(false);
		// ��������
		link.setFont(Font.font("arial", FontWeight.NORMAL, 25));
		link.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("hyperlink was clicked!");
			}
		});

		link.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				link.setScaleX(1.2);
				link.setScaleY(1.2);
			}

		});

		link.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				link.setScaleX(1);
				link.setScaleY(1);
			}

		});
		root.getChildren().add(link);

		Scene scene = new Scene(root, 600, 450);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
