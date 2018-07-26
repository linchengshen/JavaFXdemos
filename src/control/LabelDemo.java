package control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * 
 * @author yangzaozao
 *
 *
 *JavaFX API的javafx.scene.control包中的Label类可用于显示一个文本元素。
     可以包装文本元素以适应特定空间，添加图形图像或使用JavaFX Label控件应用视觉效果。
     
   创建Label对象,javafxAPIt提供3中构造函数创建Label对象
   public Label()
   public Label(String text)
   public Label(String text,Node graphic)
   
   
   //An empty label
	Label label1 = new Label();

	//A label with the text element
	Label label2 = new Label("Name");

	//A label with the text element and graphical icon
	Image image = new Image(getClass().getResourceAsStream("labels.jpg"));
	Label label3 = new Label("Name", new ImageView(image));
	
	setGraphic(Node graphic) - 设置图形图标
	setGraphicTextGap(double value)方法设置文本和图标之间的间距。
	setTextFill(Paint value)方法设置标签文本的颜色
	setTextAlignment(TextAlignment value)方法可以在其布局区域内设置标签内容的对齐方式。TextAlignment的枚举值
	setContentDisplay(ContentDisplay value)方法设置图形相对于文本的位置。ContentDisplay的枚举值
	该方法接受以下ContentDisplay常量中的一个：LFFT，RIGHT，CENTER，TOP，BOTTOM。
	
	
	包装文本
	要包装文本以将文本适合布局区域，请使用setWrapText()方法并设置为true值。
	
	应用效果
	可以对Label控件应用视觉效果或转换。以下代码将标签旋转270度，并将其位置垂直平移。
	setRotate(double value)旋转
	setTranslateX(double value)水平平移,负数是左移,移动标签
	setTranslateY(double value)垂直平移,负数是上移
	注意,这个两个方法实际上并不会修改标签的setLayoutX()和setLayoutY(),相当于出生的位置偏移因此只会出现一次效果
	如果要出现多次效果,可以通过动态设置setLayoutX()以及setLayoutY()来实现,看一下示例代码
	
	缩放效果,默认是1.0
	setScaleX(double value)
	setScaleY(double value)
   
 */
public class LabelDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("Label demo");
		Group root = new Group();

		Label label = new Label("Welcome");
		label.setLayoutX(100);
		label.setLayoutY(100);

		//设置标签字体颜色
		label.setTextFill(Color.web("#ea3153", .8));

		//设置标签字体
		label.setFont(Font.font("arial", FontPosture.ITALIC, 35));
		root.getChildren().add(label);

		//设置鼠标点击事件响应
		label.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent Event) {
				// TODO Auto-generated method stub

				//设置鼠标点击事件的水平,垂直步长
				double hStep = 5;
				double vStep = 8;
				label.setLayoutX(label.getLayoutX() + hStep);
				label.setLayoutY(label.getLayoutX() + vStep);
				System.out.println(label.getLayoutX());
				System.out.println(label.getLayoutY());
			}

		});

		//鼠标移入事件

		label.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				label.setScaleX(1.5);
				label.setScaleY(1.5);
				System.out.println("鼠标移入了");
			}
		});
		
		//鼠标移出事件
		label.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				label.setScaleX(1);
				label.setScaleY(1);
				System.out.println("鼠标移出了");
			}
		});

		Scene scene = new Scene(root, 600, 350);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
