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
 *         JavaFX API���н�UI�ؼ���ʾ������ͼ�ϵĲ����ࡣ HBox�����ཫJavaFX�ӽڵ����ˮƽ���С�
 *         �µ��ӽڵ㸽�ӵ��Ҳ��ĩβ��Ĭ������£�HBox���������ӽڵ����ѡ��Ⱥ͸߶ȡ�
 *         �����ڵ㲻�ɵ�����Сʱ������Group�ڵ㣬HBox���и߶�����Ϊ�ӽڵ�������ѡ�߶ȡ�
 * 
 *         Ĭ������£�ÿ���ӽڵ�������(Pos.TOP_LEFT)λ�ö��롣
 * 
 *         ���ǿ���ͨ����̷�ʽ�ı�HBox�Ĳ���Լ��������߿���䣬�߾࣬���Ͷ��롣
 * 
 *         �����������ŵ��ӽڵ�(��Shape�ڵ�)ʱ�����ڵ�ῼ��Shape�ľ��α߽�(ParentInBounds)�Ŀ�Ⱥ͸߶ȡ�
 * 
 *         ����������TextField�ؼ�֮��ɵ�����С�Ľڵ�ʱ�����ڵ����TextFieldˮƽ�����Ŀ��ÿռ䡣
 * 
 *         Ҫ��HBox��ˮƽ����UI�ؼ�����ʹ�þ�̬HBox.setHgrow()������
 */

/**
 * 
 * @author Administrator
 *
 *         HBox���ĸ������� 
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

		// ���ô������
		primaryStage.setTitle("HBox ����demo");

		// ���´��뽫TextField�ؼ�����Ϊ�ڵ�����HBox�Ŀ��ʱˮƽ������
		HBox hbox = new HBox();
		TextField sampleTextField = new TextField();
		// setPadding�Ǽ̳����ķ���������һ��Insets�Ķ���insets�ǲ��������˼
		// Insets��������������Insets(double value)��ʾ�ϣ��ң��£�������ͬ��ֵ
		// Insets(double top,double right,double bottom,double left);
		hbox.setPadding(new Insets(10));
		hbox.getChildren().add(sampleTextField);
		// Priority�����ȣ�����Ȩ����˼����һ��ö���࣬����������ö�ٳ�����NEVER��ALWAYS��SOMETIMES
		HBox.setHgrow(sampleTextField, Priority.ALWAYS);

		Scene scene = new Scene(hbox, 320, 120, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
