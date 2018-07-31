package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         BorderPane布局顶部，底部，左，右或中心区域中的子节点。每个区域只能有一个节点。
 *         BorderPane的顶部和底部区域允许可调整大小的节点占用所有可用宽度。 左边界区域和右边界区域占据顶部和底部边界之间的可用垂直空间。
 * 
 *         默认情况下，所有边界区域尊重子节点的首选宽度和高度。放置在顶部，底部，左侧，右侧和中心区域中的节点的默认对齐方式如下：
 * 
 *         顶部: Pos.TOP_LEFT 底部: Pos.BOTTOM_LEFT 左侧: Pos.TOP_LEFT 右侧:
 *         Pos.TOP_RIGHT 中心: Pos.CENTER
 * 
 *         BorderPane有三个构造器
 * 
 *         public BorderPane()
 * 
 *         //中心节点 public BorderPane(Node center)
 * 
 *         public BorderPane(Node center,Node top,Node right,Node bottom,Node left) 
 *         setAlignment(Pos value)这个方法是设置节点文本的对齐方式啊，而不是节点本身
 */
public class BorderPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("BorderPane布局demo");

		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10));
		primaryStage.setScene(new Scene(bp, 300, 200));

		bp.setCenter(new Button("button center"));
		bp.setTop(new Button("button top"));
		bp.setRight(new Button("button right"));
		bp.setBottom(new Button("button bottom"));
		bp.setLeft(new Button("button left"));
		Button btn = (Button) bp.getChildren().get(1);
		btn.setAlignment(Pos.TOP_CENTER);

		// 属性绑定
		btn.prefWidthProperty().bind(primaryStage.getScene().widthProperty());
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
