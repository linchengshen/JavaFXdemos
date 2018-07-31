package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *         JavaFX API具有将UI控件显示到场景图上的布局类。 HBox布局类将JavaFX子节点放在水平行中。
 *         新的子节点附加到右侧的末尾。默认情况下，HBox布局尊重子节点的首选宽度和高度。
 *         当父节点不可调整大小时，例如Group节点，HBox的行高度设置为子节点的最大首选高度。
 * 
 *         默认情况下，每个子节点与左上(Pos.TOP_LEFT)位置对齐。
 * 
 *         我们可以通过编程方式改变HBox的布局约束，例如边框，填充，边距，间距和对齐。
 * 
 *         当处理不可缩放的子节点(如Shape节点)时，父节点会考虑Shape的矩形边界(ParentInBounds)的宽度和高度。
 * 
 *         当处理诸如TextField控件之类可调整大小的节点时，父节点计算TextField水平增长的可用空间。
 * 
 *         要在HBox中水平增长UI控件，请使用静态HBox.setHgrow()方法。
 */

/**
 * 
 * @author Administrator
 *
 *         HBox有四个构造器 
 *         public HBox(){}
 * 
 *         spacing the amount of horizontal space between each child public
 *         public HBox(double spacing)
 * 
 *         children The initial set of children for this pane. public
 *         public HBox(Node... children)
 * 
 *         public HBox(double spacing ,Node... children)
 */
public class HBoxDemo extends Application {

	public void start(Stage primaryStage) {

		// 设置窗体标题
		primaryStage.setTitle("HBox 布局demo");

		// 以下代码将TextField控件设置为在调整父HBox的宽度时水平增长：
		HBox hbox = new HBox();
		TextField sampleTextField = new TextField();
		// setPadding是继承来的方法，接收一个Insets的对象insets是插入物的意思
		// Insets有两个构造器，Insets(double value)表示上，右，下，左都是相同的值
		// Insets(double top,double right,double bottom,double left);
		hbox.setPadding(new Insets(10));
		hbox.getChildren().add(sampleTextField);
		// Priority是优先，优先权的意思，是一个枚举类，有三个公共枚举常量：NEVER，ALWAYS，SOMETIMES
		HBox.setHgrow(sampleTextField, Priority.ALWAYS);

		Scene scene = new Scene(hbox, 320, 120, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
