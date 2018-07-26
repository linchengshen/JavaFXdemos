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
 *Button ʵ��demo
 *���û�������ťʱ��JavaFX Button����Դ����¼���Button����չ��Labeled�࣬������ʾ�ı���ͼ������߶����ԡ�
 *
 *
 *Button �ṩ��3��������
 *public Button() �������п��ı�����İ�ť��
 *public Button(String text) ��������ָ���ı�����İ�ť��
 *public Button(String text,Node graphic) ��������ָ���ı������ͼ��İ�ť��
 *
 *
 *��ť����
����JavaFX Button��������ǿ���ʹ�����·��������ı������ð�װͼ�ꡣ

setText(String text) - ���ð�ť���ı�����
setGraphic(Node graphic) - ����ͼ��,ͼ��Ĭ�������ı����
����ImageView�������ǿ���ʹ��javafx.scene.shape���е���״��ΪButton�е�ͼ��Ԫ�ء�

setGraphicTextGap(double value)���������ı���ͼ������֮��Ĳ�ࡣ
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
