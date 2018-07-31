package control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * 
 * @author Administrator
 *
 *
 *
 *         事件处理
 *         addEventHandler()接受两个参数，第一个参数是事件类型的对象，比如MouseEvent.MOUSE_ENTERED,
 *         第二个是EventHandler<MouseEvent>接口实现类的对象 当然，可以直接new接口，提供一个匿名内部类的对象
 *
 *
 *         第二个 学会反射中的getClass(),能够获取当前字节码对象（文件） 通过字节码文件的getResource(String
 *         name);发回一个URL对象，在调用URL对象的toExternalForm()方法 返回该URL的字符串表示形式
 *
 *         getStyleClass()返回引用到该节点上css类的列表，在调用add()来添加一个类（css文件中的类名)
 *
 *         setStyle(String style)设置css样式 getStyle()获取已经设置的cuss样式
 *
 */
public class ButtonDemo1 extends Application {

	// instance variables
	private DropShadow drop = new DropShadow();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Button DEMO");

		// 创建Button
		Button btn = new Button("accept");
		btn.setLayoutX(30);
		btn.setLayoutY(30);
		// ret代表url路径的字符串形式file:/C:/Users/Administrator/eclipse-workspace/jafafxDemos/bin/control/btn.css
		// 相对路径加载资源文件，要看相对于谁，ClassLoader()相对于编译目录，暂时可以理解为bin目录下查找
		// 通过Thread.currentThread().getContextClassLoader()来获取ClassLoader的实例
		// 通过this.getClass().getClassLoader()获取ClassLoader实例
		// getResource()是相对于当前这份字节码所在的目录
		// getResourceAsStream()和getResource(),都是获取资源文件
		// getResourceAsStream()在javaSE中是一致的，在javaweb中不一致
		// 相对于当前字节码所在路径加载文件
		// String ret = this.getClass().getResource("btnStyle.css").toExternalForm();
		// 相对于跟路径 bin目录加载文件
		String ret = Thread.currentThread().getContextClassLoader().getResource("btnStyle.css").toExternalForm();
		btn.getStylesheets().add(ret);

		// 监听事件,鼠标移入，添加效果
		btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				System.out.println("鼠标移入，添加效果");
				btn.setEffect(drop);
				// 添加css class样式
				btn.getStyleClass().add("demo");
				System.out.println(btn.getStylesheets());
			}
		});

		// 鼠标移除事件
		btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("鼠标移出，移除效果");
				// 移除css类样式
				btn.getStyleClass().remove("demo");
				btn.setEffect(null);
			}
		});

		Group root = new Group();
		root.getChildren().add(btn);
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
