package shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("矩形示例");
		Group root = new Group();

		/**
		 * javafx中定义一个矩形，包括左上角点的左边和宽高
		 */
		Rectangle rectangle = new Rectangle();
		rectangle.setX(50);
		rectangle.setY(50);
		rectangle.setWidth(200);
		rectangle.setHeight(100);
		rectangle.setFill(Color.BLACK);
		rectangle.setArcHeight(25);
		rectangle.setArcWidth(25);
		
		// 设置圆角
		//如果把圆角设置正方形宽/高的两倍，则是圆
		Rectangle rc1 = new Rectangle(50,160,100,100);
		rc1.setArcWidth(200);
		rc1.setArcHeight(200);
		
		
		//设置椭圆
		//可以看做是两个不同半径的半圆合成
		Rectangle rc2 = new Rectangle(50,270,200,100);
		rc2.setArcHeight(200);
		rc2.setArcWidth(200);

		root.getChildren().add(rectangle);
		root.getChildren().addAll(rc1,rc2);
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
