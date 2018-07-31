package layout;


import java.io.FileInputStream;
import java.io.InputStream;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *         滚动窗口提供UI元素的可滚动视图。
 *         我们使用可滚动面板，当需要显示有限的空间大内容。可滚动窗格视口，其将显示内容的一部分，并且在必要时提供滚动条。
 *         
 *         ScrollPane有两个构造器
 *         缺省的无参数构造器
 *         public ScrollPane(Node content)
 *         
 *         重要的方法：
 *         setContent(Node content)
 *         
 *         setPannable(true) 设置是否可以用鼠标拖动
 *         setPrefSize(double width,double height)
 *         
 *         滚动策略
 *         滚动条策略

			我们可以控制何时显示滚动条的策略：
			枚举值
			总是 ScrollBarPolicy.ALWAYS
			决不ScrollBarPolicy.NEVER
			必要时ScrollBarPolicy.AS_NEEDED
			setHbar策略和setVbar策略方法分别为水平和垂直滚动条指定滚动条策略。
			sp.setHbarPolicy(ScrollBarPolicy.NEVER);
			sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			
			调整滚动窗格中的组件大小

			将setFitToWidth或setFitToHeight方法设置为true以匹配特定维度。

			默认情况下，FIT_TO_WIDTH和FIT_TO_HEIGHT属性都为false，可调整大小的内容保持其原始大小。
			
 */
public class ScrollPaneDemo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("ScrollPane布局demo");
		Group root = new Group();
		ScrollPane sc = new ScrollPane();
		root.getChildren().add(sc);
		
		InputStream in = new FileInputStream("C:/Users/Administrator/Desktop/images/13.jpg");
		Image img = new Image(in);
		sc.setPrefSize(120, 120);
		sc.setPannable(true);

		sc.setContent(new ImageView(img));

		
		Scene scene = new Scene(root, 400, 400);

		
		
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
