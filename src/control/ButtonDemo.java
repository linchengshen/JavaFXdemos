package control;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * 
 * @author yangzaozao
 *
 *
 *Button 实例demo
 *当用户单击按钮时，JavaFX Button类可以触发事件。Button类扩展了Labeled类，可以显示文本，图像或两者都可以。
 *
 *
 *Button 提供了3个构造器
 *public Button() 创建带有空文本标题的按钮。
 *public Button(String text) 创建带有指定文本标题的按钮。
 *public Button(String text,Node graphic) 创建带有指定文本标题和图标的按钮。
 *
 *
 *按钮内容
创建JavaFX Button对象后，我们可以使用以下方法设置文本并设置安装图标。

setText(String text) - 设置按钮的文本标题
setGraphic(Node graphic) - 设置图标,图标默认生在文本左边
除了ImageView对象，我们可以使用javafx.scene.shape包中的形状作为Button中的图形元素。

setGraphicTextGap(double value)方法设置文本和图形内容之间的差距。
 */
public class ButtonDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Button demo");
		Group root = new Group();
		Button btn = new Button("ok",new Rectangle(40,20));
		btn.setGraphicTextGap(8 );
		root.getChildren().add(btn);
		Scene scene = new Scene(root,600,350);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
